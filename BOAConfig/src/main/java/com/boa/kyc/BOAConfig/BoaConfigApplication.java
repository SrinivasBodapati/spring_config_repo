package com.boa.kyc.BOAConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BoaConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoaConfigApplication.class, args);
	}

}

