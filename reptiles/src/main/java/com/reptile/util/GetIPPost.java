package com.reptile.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GetIPPost {

	
	public static List getIp(int page)  {
		
		List<String> list = new ArrayList<>();
			try {
				for (int j = 1; j < page; j++) {
					Connection con=Jsoup.connect("https://www.xicidaili.com/nt/"+j);//获取连接 
					con.ignoreContentType(true).ignoreHttpErrors(true);
					con.timeout(1000 * 30);
					Document document  = con.get();
					Elements trs = document.select("tr");
					org.jsoup.nodes.Element tr = null;
					Elements tds = null;
					String ip = "";
					int post = 0;
//					String post =null;
					if(trs!=null) {
						for (int i = 1,num= trs.size(); i <num; i++) {
							tr = trs.get(i);
							tds = tr.select("td");
							ip = tds.get(1).text();
							post = Integer.valueOf(tds.get(2).text());
//							post = tds.get(2).text();

//							list.add(ip+":"+post);

							try {
								connect(ip,post);
								list.add(ip+":"+post);
//								list.add(new Object[]{ip,post});
								System.out.println(j+":"+i+"="+tds.get(1).text()+"::"+tds.get(2).text());
							} catch (Exception e) {
							}
						}
						for (String l : list) {
							System.out.println(l);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return list;
			}
			return list;
	}
	
	
	
	
	public static void connect(String server, int servPort) throws Exception {
        Socket socket = new Socket();
        socket.setReceiveBufferSize(servPort);
        socket.setSoTimeout(3000);
        SocketAddress address = new InetSocketAddress(server, servPort);
        socket.connect(address,3000);//1.判断ip、端口是否可连接
    }
}
