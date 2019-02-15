package com.boa.kyc.BOAConfigClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.boa.kyc.*")
public class BoaConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaConfigClientApplication.class, args);
	}

}

