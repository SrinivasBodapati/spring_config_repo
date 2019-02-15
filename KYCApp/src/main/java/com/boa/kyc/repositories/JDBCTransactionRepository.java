package com.boa.kyc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.kyc.models.JDBCTransaction;

public interface JDBCTransactionRepository extends JpaRepository<JDBCTransaction, Integer>{

}
