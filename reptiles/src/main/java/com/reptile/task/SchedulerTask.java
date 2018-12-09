package com.reptile.task;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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
	    	
	    	for (Article article : list) {
				System.out.println(article.getArticleId());
			}
	        System.out.println("定时任务2" + new Date().getTime());
	    }

}
