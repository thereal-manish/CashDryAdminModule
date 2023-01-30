package com.finance.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.model.LoanAuthority;
import com.finance.repository.*;

@Service
public class LoanAuthorityServiceImpl implements LoanAuthorityService {

	
	@Autowired
	ManagerRepository manager_repo;
	@Autowired
	LoanAuthorityRepository lAuth_repo;
	

	
	
	public List<LoanAuthority> find()
	{
		return lAuth_repo.findAll();
	}
	
	public void save(LoanAuthority lAuth) {
		lAuth_repo.save(lAuth);
	}
	
	public LoanAuthority getLoanAuthority(String loanAuth_Id) {
		return lAuth_repo.findById(loanAuth_Id).get();
	}
	
	public void delete(String loanAuth_Id) {
		lAuth_repo.deleteById(loanAuth_Id);
	}
	public void update(LoanAuthority lAuth) {
		List<LoanAuthority> list_LoanAuthority = find();
		for(LoanAuthority cus: list_LoanAuthority) {
			if(cus.getLoanAuth_Id()==(lAuth.getLoanAuth_Id())){
				lAuth_repo.save(lAuth);
			}
			else {
				System.out.println("Wrong LoanAuthority Id");
			}
		}
	}

	@Override
	public LoanAuthority currentLoanAuthority(String loanAuth_Id) {
		LoanAuthority laa=lAuth_repo.currentLoanAuthority(loanAuth_Id);		
		return laa;
	
	}

}
