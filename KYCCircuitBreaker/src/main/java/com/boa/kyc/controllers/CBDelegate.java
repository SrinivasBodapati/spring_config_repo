package com.boa.kyc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CBDelegate {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="hanldeFallback")
	public String handleRequest(int id) {
		
		//instance level call
		String response =  restTemplate.exchange("http://localhost:7070/getcustomerbyid/{id}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
				},id).getBody();
		
		return response;
		
	}
	
	public String hanldeFallback(int id) {
		
		String response =  restTemplate.exchange("http://localhost:7080/getcustomerbyid/{id}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
				},id).getBody();
		
		return response;
		
	}
	
	@Bean
	public RestTemplate getInstance() {
		
		return new RestTemplate();
		
	}

}
