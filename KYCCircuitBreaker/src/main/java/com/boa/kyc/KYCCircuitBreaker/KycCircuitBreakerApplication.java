package com.boa.kyc.KYCCircuitBreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan(basePackages="com.boa.kyc.*")
public class KycCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KycCircuitBreakerApplication.class, args);
	}

}

