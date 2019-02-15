package com.boa.kyc.configurations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.boa.kyc.services.JDBCTransactionService;

public class JDBCTransactionImpl implements TransactionData {
	
	@Autowired
	private JDBCTransactionService jdbcService;

	@Override
	public List getAllTransactions() {
		// TODO Auto-generated method stub
		return this.jdbcService.getAllTransactions();
	}

}
