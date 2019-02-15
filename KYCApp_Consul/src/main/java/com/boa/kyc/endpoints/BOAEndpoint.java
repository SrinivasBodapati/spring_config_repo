package com.boa.kyc.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id="boa")
@Component
public class BOAEndpoint {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	/*@ReadOperation
	@Bean
	public String message() {
		
		return "Critical Message from BOA Service";
	}*/
	
	@ReadOperation
	@Bean
	public String[] getAllBeanNames() {
		
		return  applicationContext.getBeanDefinitionNames();
		
	}
}
