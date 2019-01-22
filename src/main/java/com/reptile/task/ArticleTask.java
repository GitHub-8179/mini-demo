package com.reptile.task;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.reptile.dao.ReptileDao;
import com.reptile.entity.IpPostEntity;
import com.reptile.entity.ReptileEntity;
import com.reptile.service.IReptile;

@Component
@EnableScheduling
public class ArticleTask {

	private static final Logger log = LoggerFactory.getLogger(ArticleTask.class);

	@Autowired
	private IReptile reptileImpl;
	
	private volatile List list;
	
	@Autowired
	private ReptileDao mapper;

//	@Scheduled(initialDelay = 3000,fixedRate = 6000)
//    public void job1(){
//		list.add("1");
//		System.out.println(Thread.currentThread().getName()+"当前集合数据数："+list.size());
//		
//   }
//    
//	@Scheduled(initialDelay = 3000,fixedRate = 2000)
//    public void job2(){
//		System.out.println(Thread.currentThread().getName()+"当前集合数据数："+list.size());
//   }
    
//	@Scheduled(initialDelay = 3000)
//	 @Scheduled(cron = "0 0 4 * * ?")
	@Scheduled(cron = "${setIpPost}")
    public void job3(){
		 IpPostEntity ipPostEntity = new IpPostEntity();
		List<IpPostEntity> l = mapper.selectIpPost(ipPostEntity);
		for (IpPostEntity i : l) {
			try {
				connect(i.getIp(),i.getPost());
				i.setState(1);
				mapper.insertsIpPost(i);
			} catch (Exception e) {
				i.setState(0);
				mapper.insertsIpPost(i);
			}
		}
		
		ipPostEntity.setState(1);
		l = mapper.selectIpPost(ipPostEntity);

		log.info("刷新IP成功，当前IP数量："+l.size());
		
   }
   
	
	public void connect(String server, int servPort) throws Exception {
        Socket socket = new Socket();
        socket.setReceiveBufferSize(servPort);
        socket.setSoTimeout(3000);
        SocketAddress address = new InetSocketAddress(server, servPort);
        socket.connect(address,3000);//1.判断ip、端口是否可连接
    }
}
