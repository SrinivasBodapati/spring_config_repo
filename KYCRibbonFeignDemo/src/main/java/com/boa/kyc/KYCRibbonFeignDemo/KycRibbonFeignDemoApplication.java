package com.boa.kyc.KYCRibbonFeignDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class KycRibbonFeignDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KycRibbonFeignDemoApplication.class, args);
	}

	
}

