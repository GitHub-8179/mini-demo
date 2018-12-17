package com.reptile;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;
import com.reptile.entity.ReptileEntity;
import com.reptile.service.IReptile;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan(value = "com.reptile.dao")
public class ReptilesApplication extends SpringBootServletInitializer{

	
	public static void main(String[] args) {
		SpringApplication.run(ReptilesApplication.class, args);

//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss:SSS");
//		try {
//		Date dd = new Date();
//		long l = (long) ((dd.getTime()) / 1e3);
//		System.out.println(dd.getTime());
//		long ll = (long)1e3*1543996946;
//		System.out.println((long)1e3*1543996946);
//		Date dddd = new Date(ll);
////			Date d  = formatter1.parse(Long.toString(ll));
////			System.out.println(d.getTime());
//			String formatStr =formatter.format(dddd);
//			System.out.println(formatStr);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	//配置mybatis的分页插件pageHelper
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		properties.setProperty("dialect","postgresql");    //配置postgresql数据库的方言支持Oracle,Mysql,MariaDB,SQLite,Hsqldb,PostgreSQL六种数据库
		pageHelper.setProperties(properties);
		return pageHelper;
	}
	
	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReptilesApplication.class);
    }

}


