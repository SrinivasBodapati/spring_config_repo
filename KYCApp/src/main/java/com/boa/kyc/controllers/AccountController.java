package com.boa.kyc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boa.kyc.models.Account;
import com.boa.kyc.models.Customer;
import com.boa.kyc.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	//adding the account
		@CrossOrigin("*")
		@PostMapping("/addaccount/{Id}")
		public @ResponseBody Account addAccountData(@RequestBody Account account, @PathVariable int Id) {
			return this.accountService.addAccount(account, Id);
		}
		
		@GetMapping("/getallaccounts")
		@CrossOrigin("*")
		public @ResponseBody List<Account> getAllAccountsData() {
			return this.accountService.getAllAccounts();
		}
		
		@GetMapping("/getaccountbyid/{id}")
		@CrossOrigin("*")
		public @ResponseBody Account getAccountDataById(@PathVariable int id) {
			return this.accountService.getAccountById(id);
			
		}
		
		@GetMapping("/deleteaccountbyid/{id}")
		@CrossOrigin("*")
		public void deleteAccountDataById(@PathVariable int id) {
			this.accountService.deleteAccountById(id);
			
		}
		
		@PutMapping("/updateaccounttype/{id}/{acctype}")
		@CrossOrigin("*")
		public void updateAccountType(@PathVariable int id, @PathVariable String acctype) {
			this.accountService.updateAccountType(id, acctype);
		}

}
