package com.boa.kyc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boa.kyc.configurations.DbConfiguration;
import com.boa.kyc.models.Customer;
import com.boa.kyc.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DbConfiguration dbConfig;
	
	@Value("${message}")
	String message;
	
	@GetMapping("/conditionaltran")
	public List getAllTransactions() {
		System.out.println(message);
		return dbConfig.mongoTransactions().getAllTransactions();
	}
	
	//adding the customer
	@CrossOrigin("*")
	@PostMapping("/addcustomer")
	public @ResponseBody Customer addCustomerData(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
	}
	
	@GetMapping("/getallcustomers")
	@CrossOrigin("*")
	public @ResponseBody List<Customer> getAllCustomerData() {
		return this.customerService.getAllCustomers();
	}
	
	@GetMapping("/getcustomerbyid/{id}")
	@CrossOrigin("*")
	public @ResponseBody Customer getCustomerDataById(@PathVariable int id) {
		return this.customerService.getCustomerById(id);
		
	}
	
	@GetMapping("/deletecustomerbyid/{id}")
	@CrossOrigin("*")
	public void deleteCustomerDataById(@PathVariable int id) {
		this.customerService.deleteCustomer(id);
		
	}
	
	@PutMapping("/updatecustomerfirstname/{id}/{fname}")
	@CrossOrigin("*")
	public void updateCustomerFirstName(@PathVariable int id, @PathVariable String fname) {
		this.customerService.updateFirstName(id, fname);
	}
	
	//Update customer
	@PutMapping("/updatecustomer/{id}")
	public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customer) {
		Customer cust =  this.customerService.getCustomerById(id);
		
		cust.setCustomerId(id);
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setDob(customer.getDob());
		cust.setMobileNum(customer.getMobileNum());
		cust.setAddress(customer.getAddress());
		
		Customer updateCustomer = this.customerService.addCustomer(cust);
		
		return updateCustomer;
		
	}

}
