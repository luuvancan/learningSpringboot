package com.springlearn.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Is the same 
// @ComponentScan(basePackages = "com/springlearn/webapp")
// @AutoConfiguration
// @SpringBootConfiguration
@EnableCaching
// Kích hoạt cơ chế caching của Spring, cho phép sử dụng các annotation như @Cacheable, @CachePut, @CacheEvict.
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}

}
