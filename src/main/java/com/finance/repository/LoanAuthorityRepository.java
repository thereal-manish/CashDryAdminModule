package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.model.LoanAuthority;

public interface LoanAuthorityRepository extends JpaRepository<LoanAuthority, String>{


	@Query("from LoanAuthority where loanAuth_Id=:loanAuth_Id")
	public LoanAuthority currentLoanAuthority(@Param(value="loanAuth_Id") String loanAuth_Id) ;
	
}
