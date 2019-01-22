package com.reptile.task;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageHelper;
import com.reptile.dao.ArticleMapper;
import com.reptile.dao.ArticleTypeMapper;
import com.reptile.dao.ReptileDao;
import com.reptile.entity.Article;
import com.reptile.entity.ArticleExample;
import com.reptile.entity.ArticleType;
import com.reptile.entity.ArticleTypeExample;
import com.reptile.entity.ArticleTypeExample.Criteria;
import com.reptile.entity.ArticleWithBLOBs;
import com.reptile.entity.IpPostEntity;
import com.reptile.service.Gather;
import com.reptile.service.IReptile;

@Component
@EnableScheduling
public class SchedulerTask {
	private static final Logger log = LoggerFactory.getLogger(SchedulerTask.class);

		@Autowired
		private ArticleMapper articleMapper;
		
		@Autowired
		private IReptile reptileImpl;
		@Autowired
		private ReptileDao mapper;
		@Autowired
		private ArticleTypeMapper articleTypeMapper;
		
		@Autowired
		private Gather gather;
		
		@Value("${ARTICLE_COOKIE}")
		private String ARTICLE_COOKIE ;
		
		@Value("${DATA_NUM}")
		private int DATA_NUM ;
		
		@Value("${KEYWORK_NUM}")
		private int KEYWORK_NUM ;
		
		@Value("${INTERVAL_DAY}")
		private Integer INTERVAL_DAY ;
		
	    @Scheduled(cron = "${TASK_TIME}")
	    public void job22() {
	    	job2(1);
	    }
	    
	    @Scheduled(cron = "${TASK_TIME}")
	    public void job23() {
	    	job2(3);
	    }
	    
	    public void job2(int ii ){
	    	PageHelper.startPage(ii, DATA_NUM);
	    	ArticleExample example = new ArticleExample();
	    	com.reptile.entity.ArticleExample.Criteria c  =  example.createCriteria();
	    	c.andStateEqualTo(0);
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
	    	
	    	List<IpPostEntity> ipPost = null;
	    	if(list!=null&&list.size()>0) {
	    		IpPostEntity ipPostEntity = new IpPostEntity();
	    		ipPostEntity.setState(1);
	    		ipPost = mapper.selectIpPost(ipPostEntity);
	    	}
	    	for (Article article : list) {
	    		articleId = article.getArticleId();
	    		detailsPath = article.getDetailsPath();
				try {
					i=0;
					document = Gather.getHeader( ran, detailsPath,ipPost,i,ARTICLE_COOKIE);
					if(document!=null) {
						maxInfo = document.getElementsByTag("body").text();
						if(maxInfo==null||"Maximum number of open connections reached.".equals(maxInfo)||
								"".equals(maxInfo)||
								maxInfo.startsWith("Not Found")||
								maxInfo.indexOf("Internal Privoxy Error")!=-1||
								maxInfo.indexOf("Server dropped connection")!=-1||
								maxInfo.indexOf("Host Not Found or connection failed")!=-1
								) {
							continue;}
					}else {
						continue;
					}
					record = new ArticleWithBLOBs();
					 contentDiv = document.getElementById("img-content");
					 if(contentDiv==null) {
						 record.setState(2);
					 }else {
						 contentTxt = contentDiv.text();
						 String div = contentDiv.toString();
						 div = div.replace("data-src=", "src=");
						 div = div.substring(0,div.indexOf("<script nonce"));
						 div =div+"</div>";
						 record.setDetailsDiv(div.getBytes());
						 record.setDetailsTxt(contentTxt.getBytes());
						 record.setCollectInitcount(contentTxt.length());
						 record.setState(1);
					 }
					 record.setArticleId(articleId);
					articleMapper.updateByDetails(record);
					articleId = null;
					
//					Thread.sleep(ran.nextInt(2000));
				} catch (Exception e) {
					 try {
//						 Thread.sleep(ran.nextInt(18000));
						 log.error("插入文章链接错误！"+record+":"+e.toString());
						record.setState(2);
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

	    
//	    @Scheduled(cron = "${ArticleTask}")
	    @Scheduled(initialDelay=100,fixedDelay=1000*60*5)
	    public void job1(){
		   try {
			   ArticleTypeExample example = new ArticleTypeExample();
				Criteria cl  = example.createCriteria();
				cl.andParentidNotEqualTo(0);
				
				PageHelper.startPage(1, KEYWORK_NUM);
				List<ArticleType> listArticleType = articleTypeMapper.selectKeyWork(INTERVAL_DAY);
				
	    		IpPostEntity ipPostEntity = new IpPostEntity();
	    		ipPostEntity.setState(1);
		    	List<IpPostEntity> ipPost = mapper.selectIpPost(ipPostEntity);

//		    	Calendar cld = Calendar.getInstance();//可以对每个时间域单独修改
//		    	int hour = cld.get(Calendar.HOUR_OF_DAY);
//		    	if(hour<listArticleType.size()) {
//		    		gather.setData(1,listArticleType.get(hour),ipPost);
//		    	}
		    	
		    	for (ArticleType articleType : listArticleType) {
		    		gather.setData(1,articleType,ipPost);
		    		articleTypeMapper.updateLastTime(articleType);
				}
		    	articleTypeMapper.deleteByPrimaryKey(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	    }
		   
}
