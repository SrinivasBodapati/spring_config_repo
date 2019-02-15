package com.boa.kyc.models;


import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="transactions")
public class MongoTransaction {
	
	@Id
	private String _id;
	
	private int transactionId;
	
	private long amount;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	

}
