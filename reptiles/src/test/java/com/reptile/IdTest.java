package com.reptile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;

import javax.lang.model.element.Element;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class IdTest {

	public static void main(String[] args)  {
	   	StringBuffer sb = new StringBuffer();
		BufferedReader br= null;
		InputStreamReader isr = null;
       try {
			
//			String ip ="106.87.20.231";
//			int post = 8118;
////			85.192.179.70	59802	
////			112.115.57.20	3128
////			138.68.69.65	3128
////			116.212.128.78	23500	
////			117.114.149.66 53281
////			106.87.20.231 8118
////			47.92.98.68	3128
			Connection con=Jsoup.connect("https://www.xicidaili.com/nt/1");//获取连接 
			con.ignoreContentType(true).ignoreHttpErrors(true);
		    con.timeout(1000 * 30);
		    Document document  = con.get();
		    Elements trs = document.select("tr");
		    org.jsoup.nodes.Element tr = null;
		    Elements tds = null;
		    String ip = "";
		    String post = "";
			if(trs!=null) {
				for (int i = 1,num= trs.size(); i <num; i++) {
					tr = trs.get(i);
					tds = tr.select("td");
					ip = tds.get(1).text();
					post = tds.get(2).text();
					try {
						connect(ip,Integer.valueOf(post));
						System.out.println(tds.get(1).text()+":"+tds.get(2).text()+"#;#\\");
					} catch (Exception e) {
					}
				}
			}
			
//    	   "61.135.217.7",80
//    	   connect("61.135.217.7",80);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	
	
	
	public static void connect(String server, int servPort) throws Exception {
        
		//链接ip是否通
//        InetAddress ad = InetAddress.getByName(server);
//        boolean state = ad.isReachable(3000);//测试是否可以达到该地址 ,判断ip是否可以连接 1000是超时时间
//        if(state){
//           System.out.println("连接成功" + ad.getHostAddress());
//        } else{
//           System.out.println("连接失败");
//          
//           throw new IOException();
//        }
        //1.创建一个Socket实例：构造函数向指定的远程主机和端口建立一个TCP连接
       // socket = new Socket(server, servPort);
        Socket socket = new Socket();
        socket.setReceiveBufferSize(servPort);
        socket.setSoTimeout(3000);
        SocketAddress address = new InetSocketAddress(server, servPort);
        socket.connect(address,3000);//1.判断ip、端口是否可连接
    }
}
