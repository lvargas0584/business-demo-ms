package com.bcp.business.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BusinessDemoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessDemoMsApplication.class, args);
	}

}
