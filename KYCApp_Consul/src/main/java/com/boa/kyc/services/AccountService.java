package com.boa.kyc.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.kyc.models.Account;
import com.boa.kyc.models.Customer;
import com.boa.kyc.repositories.AccountRepository;
import com.boa.kyc.repositories.CustomerRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerService customerService;

	//Add account
	@Transactional(value=TxType.REQUIRED)
	public Account addAccount(Account account, int customerId) {
		Customer customer = customerService.getCustomerById(customerId);
				//customerRepo.findById(customerId).orElse(null);
		account.setCustomer(customer);
		return accountRepository.save(account);
	}
	
	//account by id
		public Account getAccountById(int id) {
			return accountRepository.findById(id).orElse(null);
		}
		
		//select all
		//@Transactional(value = TxType.REQUIRED)
		public List<Account> getAllAccounts() {
			return accountRepository.findAll();
		}
		
		//delete account
		public void deleteAccountById(int id) {
			accountRepository.deleteById(id);
		}
		
		//update the firstName
		@Transactional(value=TxType.REQUIRED)
		public void updateAccountType(int id, String accountType) {
			accountRepository.updateAccountType(id, accountType);
		}
	
}
