package com.boa.kyc.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigClientController {
	
	@Value(value="${dataSource.url}")
	private String url;
	
	@Value(value="${db.user}")
	private String user;
	
	
	@Value(value="${db.password}")
	private String password;
	
	@Value(value="${message}")
	private String message;
	
	@GetMapping(path="/print")
	@ResponseBody
	public String printConfigProperties() {
		
		
		return url + ":" + user + ":" + password + ":" + message;
		
	}
	

}
