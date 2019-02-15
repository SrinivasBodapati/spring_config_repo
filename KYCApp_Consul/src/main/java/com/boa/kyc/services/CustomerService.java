package com.boa.kyc.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.kyc.models.Customer;
import com.boa.kyc.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//add the customer
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//customer by id
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).orElse(null);
	}
	
	//select all
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	//delete customer
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	
	//update the firstName
	@Transactional(value=TxType.REQUIRED)
	public void updateFirstName(int id, String fname) {
		customerRepository.updateCustomer(id, fname);
	}
}
