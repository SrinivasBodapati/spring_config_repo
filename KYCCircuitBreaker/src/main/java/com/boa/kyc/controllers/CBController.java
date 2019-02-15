package com.boa.kyc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CBController {
	
	@Autowired
	private CBDelegate cbDelegate;
	
	@GetMapping("/cbgetcustomerbyid/{id}")
	public String getCustomerById(@PathVariable int id) {
		
		return this.cbDelegate.handleRequest(id);
		
	}
}
