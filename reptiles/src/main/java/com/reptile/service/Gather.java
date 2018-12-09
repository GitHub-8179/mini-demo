package com.reptile.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.reptile.dao.ReptileDao;
import com.reptile.entity.ArticleType;
import com.reptile.entity.ReptileEntity;

@Service
public class Gather {

	 @Value("${WEB_URL}")
	private String WEB_URL ;
	
	@Value("${WEB_ENCODER}")
	private String WEB_ENCODER ;
	@Value("${WEB_COOKIE}")
	private String WEB_COOKIE ;
	
	@Value("${USER_AGENT}")
	private String USER_AGENT;
	
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
	
	
	public void setData(int contentType,ArticleType articleType) throws Exception {
		
		StringBuffer url = new StringBuffer(WEB_URL);
//		url.append("type=2&ie=utf8&s_from=input");
		url.append("&query="+articleType.getArticleTypeKeyword().toString().replace("&", "%26"));
		url.append("&tsn=5");
		url.append("&ft=2018-12-01");
		url.append("&et=2018-12-09");
		url.append("&wxid=");
		url.append("&usip=");
		url.append("&page=");
		url.append("&s_from=input");
		url.append("&_sug_type_=");
		
		
//		Connection con=Jsoup.connect("https://weixin.sogou.com/weixin?type=2&s_from=input&query=%E4%BC%A0%E6%84%9F%E5%99%A8%E4%BA%A7%E5%93%81&ie=utf8&_sug_=n&_sug_type_=");//获取连接 
		Connection con=Jsoup.connect(url.toString());//获取连接 
		
		
		  String urlLogin = "http://qiaoliqiang.cn/Exam/user_login.action";
	        Connection connect = Jsoup.connect(urlLogin);
		// 伪造请求头
        con.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        con.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
        con.header("Content-Length", "72").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        con.header("Host", "qiaoliqiang.cn").header("Referer", "http://qiaoliqiang.cn/Exam/");
        con.header("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");
        
        // 携带登陆信息
        con.data("username", "362501197407067215").data("password", "123456").data("user_type", "2")
                .data("isRememberme", "yes");
        
        //请求url获取响应信息
        Response res = con.ignoreContentType(true).method(Method.POST).execute();// 执行请求
        // 获取返回的cookie
        Map<String, String> cookies = res.cookies();
        for (Entry<String, String> entry : cookies.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        
        
		con.header("User-Agent", USER_AGENT);
		con.maxBodySize(0);
		Document document  = con.get();
        Elements elements1 = document.getElementsByClass("mun");
		Element elements = document.getElementsByClass("mun").last();

        if(elements !=null ) {
			Elements lis = elements.getElementsByTag("li");
        }
		
	}
	
}

