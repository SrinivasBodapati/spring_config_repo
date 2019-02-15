package com.boa.kyc.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionFilterRegistration {
	
	@Bean
	public FilterRegistrationBean<TransactionFilter> register() {
		
		FilterRegistrationBean<TransactionFilter> reg = new FilterRegistrationBean<TransactionFilter>();
		
		TransactionFilter filter = new TransactionFilter();
		reg.setFilter(filter);
		reg.addUrlPatterns("/transaction/*");
		reg.setOrder(1);
		return reg;
		
	}
	
	@Bean
	public FilterRegistrationBean<TransactionAnonymousFilter> anonymusRegister() {
		
		FilterRegistrationBean<TransactionAnonymousFilter> reg = new FilterRegistrationBean<TransactionAnonymousFilter>();
		
		TransactionAnonymousFilter filter = new TransactionAnonymousFilter();
		reg.setFilter(filter);
		reg.addUrlPatterns("/transaction/*");
		reg.setOrder(2);
		return reg;
		
	}

}
