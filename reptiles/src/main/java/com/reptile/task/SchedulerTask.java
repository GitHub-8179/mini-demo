package com.reptile.task;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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

@Component
@EnableScheduling
//implements SchedulingConfigurer
//@PropertySource("classpath:application.yml")

public class SchedulerTask {
	
//	   @Scheduled(fixedRate = 1000*4)
//	    public void job1(){
//	        System.out.println("定时任务1" + new Date());
//	    }
	 
//	   	@Value("${TASK}")
//	    @Scheduled(cron = "0/5 * * * * ?")
	    @Scheduled(cron = "${TASK_TIME}")
	    public void job2(){
	        System.out.println("定时任务2" + new Date().getTime());
	    }

}
