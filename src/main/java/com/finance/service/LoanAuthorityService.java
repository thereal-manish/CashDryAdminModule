package com.finance.service;

import java.util.List;

import com.finance.model.LoanAuthority;

public interface LoanAuthorityService {

	public List<LoanAuthority> find();

	public void save(LoanAuthority lAuth);

	public LoanAuthority getLoanAuthority(String loanAuth_Id);

	public void delete(String loanAuth_Id);

	public void update(LoanAuthority lAuth);
	public LoanAuthority currentLoanAuthority(String loanAuth_Id);

}
