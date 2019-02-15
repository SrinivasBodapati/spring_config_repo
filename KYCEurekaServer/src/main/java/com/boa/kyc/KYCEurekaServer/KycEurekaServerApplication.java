package com.boa.kyc.KYCEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class KycEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KycEurekaServerApplication.class, args);
	}

}

