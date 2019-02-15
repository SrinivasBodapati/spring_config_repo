package com.boa.kyc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boa.kyc.models.MongoTransaction;
import com.boa.kyc.services.MongoTransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private MongoTransactionService service;
	
	@RequestMapping("/transaction")
	public String loadHome(Model model) {
		
		model.addAttribute("transactionList",service.getAllTransactions());
		
		return "home";
		
	}
	
	@RequestMapping(value="/addtransaction", method=RequestMethod.POST)
	public String createTransactionData(@ModelAttribute MongoTransaction trans) {
		
		this.service.addTransaction(trans);
		
		return "redirect:transaction";
		
		
	}
	

}
