package com.reptile.task;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.reptile.dao.ArticleMapper;
import com.reptile.entity.Article;
import com.reptile.entity.ArticleExample;
import com.reptile.entity.ArticleTypeExample.Criteria;
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
	
//	   @Scheduled(fixedRate = 1000*4)
//	    public void job1(){
//	        System.out.println("定时任务1" + new Date());
//	    }
	 
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
					 try {
						record.setState(2D);
						 record.setDetailsDiv(null);
						 record.setDetailsTxt(null);
						articleMapper.updateByDetails(record);
						log.info("插入文章链接错误！"+record+":"+contentTxt);
					} catch (Exception e1) {
						log.info("修改文章状态为2错误！！"+record);
					}

				}
			}
	    	log.info("插入文章链接："+detailsPath);
	    }

}
