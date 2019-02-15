package com.boa.kyc.repositories;

import javax.transaction.Transactional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boa.kyc.models.MongoTransaction;

@Transactional
public interface MongoTransactionRepository extends MongoRepository<MongoTransaction, Integer>{

}
