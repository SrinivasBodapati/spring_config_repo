package com.boa.kyc.RibbonProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages="com.boa.kyc.*")
@EnableFeignClients(basePackages="com.boa.kyc.*")
public class RibbonProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonProjectApplication.class, args);
	}

}

