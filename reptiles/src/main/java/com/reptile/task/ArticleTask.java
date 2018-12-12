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
	 @Scheduled(cron = "0 0 4 * * ?")
    public void job3(){
		List<IpPostEntity> l = mapper.selectIpPost(null);
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
		
		System.out.println(Thread.currentThread().getName()+"当前集合数据数："+l.size());
   }
   
	
	
	public List getIp(int page)  {
		
		List<String> list = new ArrayList<>();
			try {
				IpPostEntity  ipPostEntity = null;
				for (int j = 1; j < page; j++) {
					Connection con=Jsoup.connect("https://www.xicidaili.com/nn/"+j);//获取连接 
					con.ignoreContentType(true).ignoreHttpErrors(true);
					con.timeout(1000 * 20);
					Document document  = con.get();
					Elements trs = document.select("tr");
					org.jsoup.nodes.Element tr = null;
					Elements tds = null;
					String ip = "";
					int post = 0;
					if(trs!=null) {
						for (int i = 1,num= trs.size(); i <num; i++) {
							tr = trs.get(i);
							tds = tr.select("td");
							ip = tds.get(1).text();
							post = Integer.valueOf(tds.get(2).text());
							ipPostEntity = new IpPostEntity();
							try {
								list.add(ip+":"+post);
								ipPostEntity.setIp(ip);
								ipPostEntity.setPost(post);
								ipPostEntity.setState(1);
								connect(ip,post);
								System.out.println(j+":"+i+"="+tds.get(1).text()+"::"+tds.get(2).text());
								mapper.insertsIpPost(ipPostEntity);
//								list.add(new Object[]{ip,post});
							} catch (Exception e) {
								ipPostEntity.setState(0);
								mapper.insertsIpPost(ipPostEntity);
								System.out.println(j+":"+i+"="+tds.get(1).text()+"::"+tds.get(2).text());
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return list;
			}
			return list;
	}
	
	
	
	
	public void connect(String server, int servPort) throws Exception {
        Socket socket = new Socket();
        socket.setReceiveBufferSize(servPort);
        socket.setSoTimeout(3000);
        SocketAddress address = new InetSocketAddress(server, servPort);
        socket.connect(address,3000);//1.判断ip、端口是否可连接
    }
}
