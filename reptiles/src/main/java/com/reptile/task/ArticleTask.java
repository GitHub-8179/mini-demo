package com.reptile.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.reptile.entity.ReptileEntity;
import com.reptile.service.IReptile;

//@Component
//@EnableScheduling
public class ArticleTask {

	@Autowired
	private IReptile reptileImpl;

//   @Scheduled(fixedRate = 1000*4)
    @Scheduled(cron = "0 0 4 * * ?")
    public void job1(){
	   ReptileEntity reptileEntity = null;
		try {
			reptileImpl.insert(reptileEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
   }
    
//   @Scheduled(fixedRate = 1000*4)
//    public void job2(){
//
//		System.out.println(Thread.currentThread().getName());
//   }
//    
//    @Scheduled(fixedRate = 1000*6)
//    public void job3(){
//		System.out.println(Thread.currentThread().getName());
//   }
   
}
