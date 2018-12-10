package com.reptile.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;


public class Gather {

	 @Value("${WEB_URL}")
//	private String WEB_URL ;
	 private String WEB_URL = "http://weixin.sogou.com/weixin?oq=&query=3d%E6%89%93%E5%8D%B0&_sug_type_=1&sut=0&lkt=0%2C0%2C0&s_from=input&ri=0&_sug_=n&type=2&sst0=1543993462329&page=1&ie=utf8&p=40040108&dp=1&w=01015002&dr=1";
	
	@Value("${WEB_ENCODER}")
	private String WEB_ENCODER ="utf-8";
	public void getData(String type) {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br= null;
		InputStreamReader isr = null;
		try {
			URL url = new URL(WEB_URL);//网络地址
			URLConnection uc = url.openConnection();//打开地址
			isr = new InputStreamReader(uc.getInputStream(),WEB_ENCODER);//建立管道
			br = new BufferedReader(isr);//缓冲
			
			String temp = "";//创建临时文件
			
			while ((temp=br.readLine())!=null) {
				sb.append(temp+"\n");
			}
			
			System.out.println("下載下的html"+sb.toString());
			
			Document document = Jsoup.parse(sb.toString());
			
			Element elements = document.getElementsByClass("news-list").last();
			if(elements !=null ) {
				Elements lis = elements.getElementsByTag("li");
				if(lis != null) {
					
					for (Element e : lis) {
						System.out.println(e.toString());
						Elements imgtxtBox = elements.getElementsByTag("div");
						Element txtBox = imgtxtBox.get(1);

					}
				}
				
			}
			System.out.println(elements.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br!=null)br.close();
				if(isr!=null)isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
