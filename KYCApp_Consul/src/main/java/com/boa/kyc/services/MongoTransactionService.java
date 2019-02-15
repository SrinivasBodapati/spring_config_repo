package com.boa.kyc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.kyc.models.MongoTransaction;
import com.boa.kyc.repositories.MongoTransactionRepository;

@Service
public class MongoTransactionService {
	
	@Autowired
	private MongoTransactionRepository mongorepo;
	
	//add the transaction
	public MongoTransaction addTransaction(MongoTransaction transaction) {
		
		return mongorepo.save(transaction);
		
	}
	
	//select all
	public List<MongoTransaction> getAllTransactions() {
		
		return mongorepo.findAll();
		
	}

}
