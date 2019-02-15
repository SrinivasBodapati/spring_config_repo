package com.boa.kyc.KYCRibbonFeignDemo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name="Netflix-JPA-Client",url="http://localhost:6061/",configuration = FeignClientConfiguration.class)

//reference mapped to list of servers and it is not identifying actual registeries
@FeignClient(name="KYCAPP",configuration = FeignClientConfiguration.class)
@RibbonClient(name="KYCAPP")
public interface CustomerServiceProxy {

	@GetMapping("/getallcustomers")
	public ResponseEntity<String> retrieveAssets();
		
}
