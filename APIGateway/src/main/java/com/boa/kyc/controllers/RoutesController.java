package com.boa.kyc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RoutesController {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@ResponseBody
	@GetMapping(value="/index")
	public String home() {
		
		return "<a href='showAllServiceIds'>Show All Service Ids</a>";
		
	}
	
	@ResponseBody
	@GetMapping(value="/showAllServiceIds")
	public String showAllServiceIds ( ) {
		
		List<String> serviceIds = this.discoveryClient.getServices();
		
		if(serviceIds == null || serviceIds.isEmpty()) {
			return " No services found!";
		}
		
		String html="<h3> Service Ids:</h3>";
		
		for(String serviceId : serviceIds) {
			html += "<br><a href='showService?serviceId="+serviceId +"'>"+ serviceId +"</a>";
		}
		
		return html;
	}
	
	@ResponseBody
	@GetMapping(value="/showService")
	public String showFirstService(@RequestParam(defaultValue = "") String serviceId) {
		
		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
		
		if(instances == null || instances.isEmpty()) {
			return " No instances for service:" + serviceId;
		}
		
		String html="<h2> Instances for Service Id: " + serviceId + "</h2>";
		
		for(ServiceInstance instance : instances) {
			html += "<h3>Instance: " + instance.getUri() + "</h3>";
			html += "Host: " + instance.getHost() + "<br>";
			html += "Port: " + instance.getPort() + "<br>";
			html += "SubPath: " + instance.getMetadata() + "<br>";
		}
		
		return html;
		
	}
	
	

}
