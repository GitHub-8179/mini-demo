package com.reptile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan(value = "com.reptile.dao")
public class ReptilesApplication {

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
}

//1543996946
//1543997461074
//1543997673661
