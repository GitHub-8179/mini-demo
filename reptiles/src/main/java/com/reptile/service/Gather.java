package com.reptile.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
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
	
	@Autowired
	private ReptileDao mapper;
	
	public void getData(int contentType,String query,Integer articleTypeId) {
		
		StringBuffer sb = new StringBuffer();
		BufferedReader br= null;
		InputStreamReader isr = null;
		try {
//			URL url = new URL(WEB_URL.replace("{query}", query));//网络地址
//			URLConnection uc = url.openConnection();//打开地址
//			isr = new InputStreamReader(uc.getInputStream(),WEB_ENCODER);//建立管道
//			br = new BufferedReader(isr);//缓冲
//			
//			String temp = "";//创建临时文件
//			
//			while ((temp=br.readLine())!=null) {
//				sb.append(temp+"\n");
//			}
////			System.out.println("下載下的html"+sb.toString());
//			Document document = Jsoup.parse(sb.toString());
			String s = "http://weixin.sogou.com/weixin?type=2&s_from=input&query="+query.replace("&", "%26")+"&ie=utf8&_sug_=y&_sug_type_=";
			Connection con=Jsoup.connect(s);//获取连接 

//			Connection con=Jsoup.connect(WEB_URL.replace("{query}", query));//获取连接 
//			con.cookie(name, value);
	        con.header("Cookie", WEB_COOKIE);//配置模拟浏览器  
			con.maxBodySize(0);
	        Response rs= con.execute();//获取响应  
	        Document document=Jsoup.parse(rs.body());//转换为Dom树 
			
			Element elements = document.getElementsByClass("news-list").last();
			if(elements !=null ) {
				Elements lis = elements.getElementsByTag("li");
				if(lis != null) {
					List<ReptileEntity> list = new ArrayList<ReptileEntity>();
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
//						Element txtBox = imgtxtBox.get(1);

						String articleTitle = imgtxtBox.select("h3").last().text();

//						String articleTitle = txtBox.getElementsByTag("h3").last().text();
						reptileEntity.setArticleTitle(articleTitle);
						
//						String articleKeyword = txtBox.getElementsByTag("em").last().text();
						reptileEntity.setArticleKeyword(query);
						
//						String value = txtBox.getElementsByTag("p").last().text();
						String contentExcerpt = imgtxtBox.select("p").last().text();
						reptileEntity.setContentExcerpt(contentExcerpt);
//						Elements value1 = imgtxtBox.select("a");

						
						Element txtBox2 = imgtxtBox.get(2);
						String source = txtBox2.getElementsByTag("a").first().text();
						reptileEntity.setSource(source);

						Long createTime =  Long.valueOf(txtBox2.attr("t"));
//						Long articleId = (long) (1e3* Long.valueOf(txtBox2.attr("t")));
						
						reptileEntity.setCreateTime( createTime);
						
						reptileEntity.setContentType(contentType);
						mapper.insert(reptileEntity);
						list.add(reptileEntity);
					}
//					mapper.inserts(list);
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
		url.append("?type=2&ie=utf8&s_from=input");
//		url.append("&query="+articleType.getArticleTypeKeyword().toString().replace("&", "%26"));
		url.append("&query="+articleType.getArticleTypeKeyword());
//		url.append("&tsn=5");
//		url.append("&ft=2018-12-01");
//		url.append("&et=2018-12-09");
//		url.append("&wxid=");
//		url.append("&usip=");
		url.append("&page=#;#;");
		url.append("&_sug_type_=");
		url.append("&_sug_=n");
		
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
		 Document document = null;
		 int i = 0;
		 String maxInfo ="";
		 int j = 1;
		 for (int j2 = 1; j2 < 100; j2++) {
			
//		while(true) {
			 urlPath = url.toString().replace("#;#;",j2+"");
			document = getHeader(ran,urlPath,ipPost,i);
			maxInfo = document.getElementsByTag("body").text();
			if(document==null||
				"Maximum number of open connections reached.".equals(maxInfo)||
				"".equals(maxInfo)||
				maxInfo.startsWith("Not Found")||
				maxInfo.indexOf("Internal Privoxy Error")!=-1||
				maxInfo.indexOf("Server dropped connection")!=-1||
				maxInfo.indexOf("Host Not Found or connection failed")!=-1
				) {
				System.out.println(maxInfo);
				continue;}
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
						
						reptileEntity.setArticleKeyword(articleType.getArticleTypeName());
						
						contentExcerpt = imgtxtBox.select("p").last().text();
						reptileEntity.setContentExcerpt(contentExcerpt);
						
						Element txtBox2 = imgtxtBox.get(2);
						source = txtBox2.getElementsByTag("a").first().text();
						reptileEntity.setSource(source);
	//						
	//						source = imgtxtBox.select("a").last().text();
	//						reptileEntity.setSource(source);
	//
	//						createTime =  Long.valueOf(imgtxtBox.select("a").last().attr("t"));
						createTime =  Long.valueOf(txtBox2.attr("t"));
						reptileEntity.setCreateTime( createTime);
						
						reptileEntity.setContentType(contentType);
						
						mapper.insert(reptileEntity);
					}
				}
				
			}
//			sogouNext = document.getElementById("sogou_next");
//			if(sogouNext==null) {
//				log.info(articleType.getArticleTypeKeyword()+"访问到此结束："+urlPath);
//				break;
//			}else {
//				urlPath = sogouNext.attr("href");
//				urlPath= WEB_URL +urlPath;
//				sogouNext = null;
//			}
			log.info("访问地址："+urlPath+"——长度："+maxInfo.length());
			Thread.sleep(ran.nextInt(100000));

		}
		
		
	}


	public static Document getHeader(Random ran,String url,List<IpPostEntity> ipPost,int i) {
		Document document =null;
		try {
			Connection con= Jsoup.connect(url);//获取连接 
		
		con.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        con.header("Accept-Encoding", "gzip, deflate, br");
        con.header("Accept-Language", "zh-CN,zh;q=0.9");
        con.header("Connection", "keep-alive");
        con.header("Upgrade-Insecure-Requests", "1");
//        String[] sp = ipPost.get(ran.nextInt(ipPost.size())).split(":");
        IpPostEntity sp = ipPost.get(ran.nextInt(ipPost.size()));
        con.proxy(sp.getIp(), sp.getPost());
        con.header("User-Agent", userAgent.get(ran.nextInt(userAgent.size())));
        
        con.header("Host", "weixin.sogou.com");
        con.header("Referer", url);
//        con.header("Cookie", "ABTEST=8|1544313106|v1; SNUID=0B47ECD8706A0CFB0559A44C704AEBC9; IPLOC=CN3301; SUID=7B379CB74018960A000000005C0C5913; SUID=7B379CB72C18960A000000005C0C5913; weixinIndexVisited=1; SUV=00201C77B79C377B5C0C5916385A3734; ppinf=5|1544317817|1545527417|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MjAxN3x1bmlxbmFtZToxODolRTQlQkUlOUQlRTYlOTclQTd8Y3J0OjEwOjE1NDQzMTc4MTd8cmVmbmljazoxODolRTQlQkUlOUQlRTYlOTclQTd8dXNlcmlkOjQ0Om85dDJsdU1kbmsxVVdseWNjQ043Wkk5cGFaa1lAd2VpeGluLnNvaHUuY29tfA; pprdig=ZnrKxJTqVa_HUcaksE84209m-IIEtE-rqCZEYdH701HIlEoBc4r40OCOlo8Jv6A2KonQLsfnS5UD03XXVV1AOvgquS2J4iRUhSSU1cu-yNq4Dl0ujTqbP5THSgGvygISt2M-MRMxrM7GfGg2HC71UW6eeKoCKavQUX6yMdoxtyo; sgid=03-36145051-AVwMa3m3GicQ58O6ltvB9vtw; ppmdig=15443530730000003295079107421ccd971fa389d5e6f03a; sct=15; JSESSIONID=aaaIQXOl_9SDD6V9Lo_Cw");
        con.header("Cookie", "ABTEST=8|1544313106|v1; SNUID=0B47ECD8706A0CFB0559A44C704AEBC9; IPLOC=CN3301; SUID=7B379CB74018960A000000005C0C5913; SUID=7B379CB72C18960A000000005C0C5913; weixinIndexVisited=1; SUV=00201C77B79C377B5C0C5916385A3734; ppinf=5|1544317817|1545527417|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MjAxN3x1bmlxbmFtZToxODolRTQlQkUlOUQlRTYlOTclQTd8Y3J0OjEwOjE1NDQzMTc4MTd8cmVmbmljazoxODolRTQlQkUlOUQlRTYlOTclQTd8dXNlcmlkOjQ0Om85dDJsdU1kbmsxVVdseWNjQ043Wkk5cGFaa1lAd2VpeGluLnNvaHUuY29tfA; pprdig=ZnrKxJTqVa_HUcaksE84209m-IIEtE-rqCZEYdH701HIlEoBc4r40OCOlo8Jv6A2KonQLsfnS5UD03XXVV1AOvgquS2J4iRUhSSU1cu-yNq4Dl0ujTqbP5THSgGvygISt2M-MRMxrM7GfGg2HC71UW6eeKoCKavQUX6yMdoxtyo; sgid=03-36145051-AVwMa3m3GicQ58O6ltvB9vtw; SUIR=0B47ECD8706A0CFB0559A44C704AEBC9; sct=21; JSESSIONID=aaajt__2Pf9d2eETjK_Cw; ppmdig=15445330070000006c5188cea50d4ab1333d5d5d5e79f32a");
        con.ignoreContentType(true).ignoreHttpErrors(true);
        con.timeout(1000 * 30);
		con.maxBodySize(0);
		System.setProperty("https.proxySet", "true");
		System.getProperties().setProperty("http.proxyHost", sp.getIp());
		System.getProperties().setProperty("http.proxyPort", sp.getPost()+"");
			document  = con.get();
		} catch (Exception e) {
			if(i==10) {
				return null;
			}
			i++;
			log.error("网络请求异常："+i+e.toString());
			return getHeader(ran,url,ipPost,i);
		}
		return  document;
	}
	
}

