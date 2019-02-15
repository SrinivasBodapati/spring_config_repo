package com.boa.kyc.controllers;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="KYCAPP", configuration =  FeignClientConfiguration.class)
@RibbonClient(name="KYCAPP")
//@Service
public interface CustomerServiceProxy {
	
	@GetMapping("/getallcustomers")
	public ResponseEntity<String> retrieveAssets() ;


}
