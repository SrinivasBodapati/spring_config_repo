package com.boa.kyc.KYCRibbonFeignDemo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;


@RestController
public class CustomerController {
    @Autowired  
 	private CustomerServiceProxy customerServiceProxy;
    
	@GetMapping(value="/getfeigncustomers")
	public String getFeignCustomerData()
	{
		
		ResponseEntity<String> responseEntity=customerServiceProxy.retrieveAssets();
		
		return responseEntity.getBody();
	}
	
	@GetMapping(value="/getLBcustomers")
	public String getLBCustomerData() throws RestClientException, IOException
	{
		
		return new LoadBalanceCustomerProxy().getCustomers("/getLBcustomers");
		
		
	}
	
	
}
