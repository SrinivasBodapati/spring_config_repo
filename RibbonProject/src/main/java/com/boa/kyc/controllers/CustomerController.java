package com.boa.kyc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceProxy customerProxy;
	
	
	
	
	@GetMapping("/getfeigncustomers")
	public String getFeignCustomers() {
		
		ResponseEntity<String>  responseEntity = customerProxy.retrieveAssets();
		return responseEntity.getBody();
		
		//return this.customerProxy.getFeignCustomers();
		
		
	}

}
