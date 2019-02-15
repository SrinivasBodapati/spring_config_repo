package com.boa.kyc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.kyc.models.JDBCTransaction;
import com.boa.kyc.repositories.JDBCTransactionRepository;

@Service
public class JDBCTransactionService {
	
	@Autowired
	private JDBCTransactionRepository jdbcrepo;
	
	//add transaction
	
	public JDBCTransaction addTransaction(JDBCTransaction trans) {
		
		return jdbcrepo.save(trans);
		
	}
	
	//get all transactions
	 
	public List<JDBCTransaction> getAllTransactions() {
		return jdbcrepo.findAll();
		
	}

}
