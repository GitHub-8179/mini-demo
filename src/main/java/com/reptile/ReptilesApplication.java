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
public class ReptilesApplication extends SpringBootServletInitializer{

	
	public static void main(String[] args) {
		SpringApplication.run(ReptilesApplication.class, args);

	}

	
	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ReptilesApplication.class);
    }
	 
		@Bean
		public PageHelper pageHelper(){
			PageHelper pageHelper = new PageHelper();
			Properties properties = new Properties();
			properties.setProperty("offsetAsPageNum","true");
			properties.setProperty("rowBoundsWithCount","true");
			properties.setProperty("reasonable","true");
			properties.setProperty("dialect","postgresql");  
			pageHelper.setProperties(properties);
			return pageHelper;
		}

}


