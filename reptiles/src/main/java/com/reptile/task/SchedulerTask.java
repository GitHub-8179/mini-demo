package com.reptile.task;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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

@Component
@EnableScheduling
//implements SchedulingConfigurer
//@PropertySource("classpath:application.yml")

public class SchedulerTask {
	
		@Autowired
		private ArticleMapper articleMapper;
	
//	   @Scheduled(fixedRate = 1000*4)
//	    public void job1(){
//	        System.out.println("定时任务1" + new Date());
//	    }
	 
//	    @Scheduled(cron = "0/30 * * * * ?")
	    @Scheduled(cron = "${TASK_TIME}")
	    public void job2(){
	    	PageHelper.startPage(1, 5);
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
	    	for (Article article : list) {
	    		articleId = article.getArticleId();
				
				try {
				con =Jsoup.connect(article.getDetailsPath());//获取连接 

				con.maxBodySize(0);
				con.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
		                "gzip, deflate");
		        con.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
		        con.header("Content-Length", "72").header("Content-Type",
		                "application/x-www-form-urlencoded; charset=UTF-8");
		        con.header("Host", "qiaoliqiang.cn").header("Referer", "http://qiaoliqiang.cn/Exam/");
		        con.header("User-Agent",
		                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
		                .header("X-Requested-With", "XMLHttpRequest");
			        
				document = con.get();
				System.out.println(document.toString());
				
				record = new ArticleWithBLOBs();
				 contentDiv = document.getElementById("img-content");
				 if(contentDiv==null) {
					 record.setState(3D);
				 }else {
					 contentTxt = contentDiv.text();
					 record.setDetailsDiv(contentDiv.toString().getBytes());
					 record.setDetailsTxt(contentTxt.getBytes());
					 record.setState(1D);
				 }
				 record.setArticleId(articleId);
				articleMapper.updateByDetails(record);
				articleId = null;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			}
	        System.out.println("定时任务2" + new Date().getTime());
	    }

}
