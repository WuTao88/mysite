package com.sample.mysite;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.unit.DataSize;



@SpringBootApplication
@EnableJpaAuditing
//@Configuration
public class MysiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysiteApplication.class, args);
	}

//	@Bean
//	public MultipartConfigElement multipartConfigElement() {
//	   MultipartConfigFactory factory = new MultipartConfigFactory();
//	   //  单个数据大小
//	   DataSize ds=DataSize.ofMegabytes(100);
//	   factory.setMaxFileSize(ds);
//	   /// 总上传数据大小
//	   factory.setMaxFileSize(ds);
//	   return factory.createMultipartConfig();
//	}
}
