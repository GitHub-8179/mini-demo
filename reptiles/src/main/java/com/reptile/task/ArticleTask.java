package com.reptile.task;

import java.util.List;

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
	
	private volatile List list;

	@Scheduled(initialDelay = 3000,fixedRate = 6000)
    public void job1(){
		list.add("1");
		System.out.println(Thread.currentThread().getName()+"当前集合数据数："+list.size());
		
   }
    
	@Scheduled(initialDelay = 3000,fixedRate = 2000)
    public void job2(){
		System.out.println(Thread.currentThread().getName()+"当前集合数据数："+list.size());
   }
    
	@Scheduled(initialDelay = 3000,fixedRate = 3000)
    public void job3(){
		System.out.println(Thread.currentThread().getName()+"当前集合数据数："+list.size());
   }
   
}
