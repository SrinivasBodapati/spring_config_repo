package com.boa.kyc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boa.kyc.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Modifying
	@Query("update Account set accountType=:acctype where accountId=:Id")
	void updateAccountType(@Param("Id") int id, @Param("acctype") String acctype);

}
