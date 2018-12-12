package com.reptile.task;

import java.util.List;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.reptile.dao.ArticleMapper;
import com.reptile.dao.ArticleTypeMapper;
import com.reptile.entity.Article;
import com.reptile.entity.ArticleExample;
import com.reptile.entity.ArticleType;
import com.reptile.entity.ArticleTypeExample;
import com.reptile.entity.ArticleTypeExample.Criteria;
import com.reptile.entity.ArticleWithBLOBs;
import com.reptile.service.Gather;
import com.reptile.service.IReptile;
import com.reptile.util.GetIPPost;

@Component
@EnableScheduling
//implements SchedulingConfigurer
//@PropertySource("classpath:application.yml")
public class SchedulerTask {
	private static final Logger log = LoggerFactory.getLogger(SchedulerTask.class);

		@Autowired
		private ArticleMapper articleMapper;
		
		@Autowired
		private IReptile reptileImpl;
		
		@Autowired
		private ArticleTypeMapper articleTypeMapper;
		
		@Autowired
		private Gather gather;
		
		public List ipPost;
	 
	    @Scheduled(cron = "${TASK_TIME}")
	    public void job2(){
	    	PageHelper.startPage(1, 10);
	    	ArticleExample example = new ArticleExample();
	    	com.reptile.entity.ArticleExample.Criteria c  =  example.createCriteria();
	    	c.andStateEqualTo(0D);
	    	List<Article> list = articleMapper.selectByExample(example);
	    	Document document = null;
	    	ArticleWithBLOBs record = null;
	    	Element contentDiv = null;
	    	String contentTxt = null;
	    	String articleId = null;
	    	Random ran = new Random();
	    	String detailsPath = null;
	    	int i =0 ;
	    	String maxInfo ="";
	    	
	    	if(ipPost==null||ipPost.size()==0) {ipPost = GetIPPost.getIp(6);}
	    	for (Article article : list) {
	    		articleId = article.getArticleId();
	    		detailsPath = article.getDetailsPath();
				try {
					i=0;
					document = Gather.getHeader( ran, detailsPath,ipPost,i);
					maxInfo = document.getElementsByTag("body").text();
					if(document==null||
					"Maximum number of open connections reached.".equals(maxInfo)||
					maxInfo.indexOf("Internal Privoxy Error")!=-1||
					maxInfo.indexOf("Server dropped connection")!=-1||
					maxInfo.indexOf("Host Not Found or connection failed")!=-1

					) {continue;}
					record = new ArticleWithBLOBs();
					 contentDiv = document.getElementById("img-content");
					 if(contentDiv==null) {
						 record.setState(2D);
					 }else {
						 contentTxt = contentDiv.text();
						 record.setDetailsDiv(contentDiv.toString().getBytes());
						 record.setDetailsTxt(contentTxt.getBytes());
						 record.setState(1D);
					 }
					 record.setArticleId(articleId);
					articleMapper.updateByDetails(record);
					articleId = null;
					
					Thread.sleep(ran.nextInt(2000));
				} catch (Exception e) {
					 try {
//						 Thread.sleep(ran.nextInt(18000));
						 log.error("插入文章链接错误！"+record+":"+e.toString());
						record.setState(2D);
						 record.setDetailsDiv(null);
						 record.setDetailsTxt(null);
						articleMapper.updateByDetails(record);
					} catch (Exception e1) {
						log.error("修改文章状态为2错误！！"+record);
					}
				}
				log.info("插入文章链接："+detailsPath);
			}
	    }

	    
	    @Scheduled(cron = "${ArticleTask}")
	    public void job1(){
		   try {
			   ArticleTypeExample example = new ArticleTypeExample();
				Criteria c  = example.createCriteria();
				c.andParentidNotEqualTo(0);
				List<ArticleType> listArticleType = articleTypeMapper.selectByExample(example);
					
		    	if(ipPost==null||ipPost.size()==0) {ipPost = GetIPPost.getIp(6);}
				
				for (ArticleType articleType : listArticleType) {
					gather.setData(1,articleType,ipPost);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    }
		   
	   @Scheduled(cron = "${setIpPost}")
	    public void setIpPost(){
		   try {
			    ipPost = GetIPPost.getIp(6);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }
	   
}
