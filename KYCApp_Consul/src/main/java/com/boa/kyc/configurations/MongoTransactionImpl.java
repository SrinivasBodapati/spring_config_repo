package com.boa.kyc.configurations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.boa.kyc.services.MongoTransactionService;

public class MongoTransactionImpl implements TransactionData {
	
	@Autowired
	private MongoTransactionService mongoService;

	@Override
	public List getAllTransactions() {
		// TODO Auto-generated method stub
		return this.mongoService.getAllTransactions();
	}

}
