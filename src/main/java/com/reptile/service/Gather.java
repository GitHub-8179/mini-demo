package com.reptile.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.reptile.dao.ReptileDao;
import com.reptile.entity.ArticleType;
import com.reptile.entity.IpPostEntity;
import com.reptile.entity.ReptileEntity;

@Service
@PropertySource({"classpath:webUser.properties","classpath:application.yml"})

public class Gather {
	
	private static final Logger log = LoggerFactory.getLogger(Gather.class);

	 @Value("${WEB_URL}")
	private String WEB_URL ;
	@Value("${WEB_COOKIE}")
	private String WEB_COOKIE ;
	
	public static List<String> userAgent;
	
	public List<String> getUserAgent() {
		return userAgent;
	}
	@Value("#{'${UserAgentValue}'.split('#;#')}")
	public void setUserAgent(List<String> userAgent) {
		this.userAgent = userAgent;
	}
	
	@Value("${WEB_CONDITION}")
	private String WEB_CONDITION ;
	
	@Autowired
	private ReptileDao mapper;
	
	public void getData(int contentType,String query,Integer articleTypeId) {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br= null;
		InputStreamReader isr = null;
		try {
			String s = "http://weixin.sogou.com/weixin?type=2&s_from=input&query="+query.replace("&", "%26")+"&ie=utf8&_sug_=y&_sug_type_=";
			Connection con=Jsoup.connect(s);//获取连接 

	        con.header("Cookie", WEB_COOKIE);//配置模拟浏览器  
			con.maxBodySize(0);
	        Response rs= con.execute();//获取响应  
	        Document document=Jsoup.parse(rs.body());//转换为Dom树 
			
			Element elements = document.getElementsByClass("news-list").last();
			if(elements !=null ) {
				Elements lis = elements.getElementsByTag("li");
				if(lis != null) {
					ReptileEntity reptileEntity=null;
					for (Element e : lis) {
						
						reptileEntity = new ReptileEntity();
						reptileEntity.setArticleTypeId(articleTypeId);
//						System.out.println(e.toString());
						Elements imgtxtBox = e.getElementsByTag("div");
						String articleId = e.attr("d");
						
						String detailsPath = imgtxtBox.select("a").first().attr("href");
						reptileEntity.setDetailsPath(detailsPath);
//						
						reptileEntity.setArticleId(articleId.substring(articleId.lastIndexOf("-")+1));
						
						
						reptileEntity.setContentCrawl(imgtxtBox.toString().getBytes());

						String articleTitle = imgtxtBox.select("h3").last().text();

						reptileEntity.setArticleTitle(articleTitle);
						reptileEntity.setArticleKeyword(query);
						
						String contentExcerpt = imgtxtBox.select("p").last().text();
						reptileEntity.setContentExcerpt(contentExcerpt);

						
						Element txtBox2 = imgtxtBox.get(2);
						String source = txtBox2.getElementsByTag("a").first().text();
						reptileEntity.setSource(source);

						Long createTime =  Long.valueOf(txtBox2.attr("t"));
						
						reptileEntity.setCreateTime( createTime);
						
						reptileEntity.setContentType(contentType);
						mapper.insert(reptileEntity);
					}
				}
				
			}
			
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
	
	
	public int getNum(String num) {
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(num);  
		System.out.println( m.replaceAll("").trim());
		return Integer.valueOf( m.replaceAll("").trim() );
	}
	
	
	public void setData(int contentType,ArticleType articleType,List<IpPostEntity> ipPost) throws Exception {

		StringBuffer url = new StringBuffer(WEB_URL);
		url.append("?");
		url.append(WEB_CONDITION);
//		url.append("page=11");
//		url.append("&query=避障");
		url.append("&query="+articleType.getArticleTypeKeyword().toString().replace("&", "与"));
		
		 Random ran =  new Random() ;
		 Element sogouNext = null;
		 ReptileEntity reptileEntity=null;
		 Elements imgtxtBox =null;
		 String detailsPath =null;
		 String articleId = null;
		 String articleTitle =null;
		 String contentExcerpt = null;
		 String source = null;
		 Long createTime = 0L;
		 String urlPath = url.toString();
		 urlPath = urlPath.replace("startTime", articleType.getIamgeIcon());
		 urlPath = urlPath.replace("endTime", articleType.getIamgeBack());
//		 urlPath = urlPath.replace("startTime", "2017-01-01");
//		 urlPath = urlPath.replace("endTime", "2017-01-13");
		 Document document = null;
		 int i = 0;
		 String maxInfo ="";
		 int j = 0;
			
		while(true) {
			document = getHeader(ran,urlPath,ipPost,i,WEB_COOKIE);
			if(document!=null) {
				maxInfo = document.getElementsByTag("body").text();
				if(maxInfo==null||
						"Maximum number of open connections reached.".equals(maxInfo)||
						"".equals(maxInfo)||
						maxInfo.startsWith("Not Found")||
						maxInfo.indexOf("Internal Privoxy Error")!=-1||
						maxInfo.indexOf("Server dropped connection")!=-1||
						maxInfo.indexOf("Host Not Found or connection failed")!=-1||
						maxInfo.length()<300
						) {
					 Thread.sleep(ran.nextInt(18000));
					continue;}
			}else {
				 Thread.sleep(ran.nextInt(18000));
				continue;
			}
			Element elements = document.getElementsByClass("news-list").last();
			if(elements !=null ) {
				Elements lis = elements.getElementsByTag("li");
				if(lis != null) {
	
					for (Element e : lis) {
						
						reptileEntity = new ReptileEntity();
						reptileEntity.setArticleTypeId(articleType.getArticleTypeId());
						imgtxtBox = e.getElementsByTag("div");
						
						articleId = e.attr("d");
						articleId = articleId.substring(articleId.lastIndexOf("-")+1);
						reptileEntity.setArticleId(articleId);
						
						detailsPath = imgtxtBox.select("a").first().attr("href");
						reptileEntity.setDetailsPath(detailsPath);
						
						reptileEntity.setContentCrawl(imgtxtBox.toString().getBytes());
	
						articleTitle = imgtxtBox.select("h3").last().text();
						reptileEntity.setArticleTitle(articleTitle);
						
						reptileEntity.setArticleKeyword(articleType.getArticleTypeKeyword());
						
						contentExcerpt = imgtxtBox.select("p").last().text();
						reptileEntity.setContentExcerpt(contentExcerpt);
						
						Element txtBox2 = imgtxtBox.get(2);
						source = txtBox2.getElementsByTag("a").first().text();
						reptileEntity.setSource(source);
						createTime =  Long.valueOf(txtBox2.attr("t"));
						reptileEntity.setCreateTime( createTime);
						
						reptileEntity.setContentType(contentType);
						
						mapper.insert(reptileEntity);
					}

				}
				
			}
			sogouNext = document.getElementById("sogou_next");
			if(sogouNext==null) {
				if(j==3) {
					log.info(articleType.getArticleTypeKeyword()+"访问到此结束："+urlPath);
					break;
				}else {
					j++;
					Thread.sleep(ran.nextInt(18000));
					continue;
				}
			}else {
				j=0;
				urlPath = sogouNext.attr("href");
				urlPath= WEB_URL +urlPath;
				sogouNext = null;
			}
			log.info("访问地址："+urlPath+"——长度："+maxInfo.length());

		}
		
		
	}


	public static Document getHeader(Random ran,String url,List<IpPostEntity> ipPost,int i,String cookie) {
		Document document =null;
		IpPostEntity sp = ipPost.get(ran.nextInt(ipPost.size()));
		String ip =sp.getIp();
		int post = sp.getPost();
		try {
			Connection con= Jsoup.connect(url);//获取连接 
		
		con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        con.header("Accept-Encoding", "gzip, deflate, br");
        con.header("Accept-Language", "zh-CN,zh;q=0.9");
        con.header("Connection", "keep-alive");
        con.header("Upgrade-Insecure-Requests", "1");
        con.proxy(ip, post);
        con.header("User-Agent", userAgent.get(ran.nextInt(userAgent.size())));
        
        con.header("Host", "weixin.sogou.com");
        con.header("Referer", url);
        
        con.header("Cookie", cookie);

        con.ignoreContentType(true).ignoreHttpErrors(true);
        con.timeout(1000 * 30);
		con.maxBodySize(0);
		System.setProperty("https.proxySet", "true");
		System.getProperties().setProperty("http.proxyHost", ip);
		System.getProperties().setProperty("http.proxyPort", post+"");
			document  = con.get();
		} catch (Exception e) {
			if(i==10) {
				return null;
			}
			i++;
			return getHeader(ran,url,ipPost,i,cookie);
		}

		return  document;
	}
	
}

