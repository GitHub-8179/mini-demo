package com.reptile.task;

import java.util.List;
import java.util.Random;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
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
import com.reptile.entity.Article;
import com.reptile.entity.ArticleExample;
import com.reptile.entity.ArticleWithBLOBs;
import com.reptile.service.Gather;

@Component
@EnableScheduling
//implements SchedulingConfigurer
//@PropertySource("classpath:application.yml")
public class SchedulerTask {
	private static final Logger log = LoggerFactory.getLogger(SchedulerTask.class);

		@Autowired
		private ArticleMapper articleMapper;
		
	 
//	    @Scheduled(cron = "0/30 * * * * ?")
	    @Scheduled(cron = "${TASK_TIME}")
	    public void job2(){
	    	PageHelper.startPage(1, 10);
	    	ArticleExample example = new ArticleExample();
	    	com.reptile.entity.ArticleExample.Criteria c  =  example.createCriteria();
	    	c.andStateEqualTo(0D);
	    	List<Article> list = articleMapper.selectByExample(example);
	    	Connection con = null;
	    	Document document = null;
	    	ArticleWithBLOBs record = null;
	    	Element contentDiv = null;
	    	String contentTxt = null;
	    	String articleId = null;
	    	Random ran = new Random();
	    	String detailsPath = null;
	    	for (Article article : list) {
	    		articleId = article.getArticleId();
	    		detailsPath = article.getDetailsPath();
				try {
					con =Jsoup.connect(detailsPath);//获取连接 
					con = Gather.getHeader(con, ran, detailsPath);
				        
					document = con.get();
					
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
					
					Thread.sleep(ran.nextInt(18000));
				} catch (Exception e) {
					e.printStackTrace();
					 try {
						 Thread.sleep(ran.nextInt(18000));
						record.setState(2D);
						 record.setDetailsDiv(null);
						 record.setDetailsTxt(null);
						articleMapper.updateByDetails(record);
						log.error("插入文章链接错误！"+record+":"+contentTxt);
					} catch (Exception e1) {
						log.error("修改文章状态为2错误！！"+record);
					}
				}
				log.info("插入文章链接："+detailsPath);
			}
	    }

}
