package com.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.model.Manager;
import com.finance.repository.LoanAuthorityRepository;
import com.finance.repository.ManagerRepository;


@Service
public class ManagerServiceImpl implements ManagerService{
	

	@Autowired
	ManagerRepository manager_repo;
	@Autowired
	LoanAuthorityRepository lAuth_repo;

	
	public List<Manager> find()
	{
		return manager_repo.findAll();
	}
	
	public void save(Manager m) {
		manager_repo.save(m);
		System.out.println("saved successfully");
	}
	
	public Manager getManager(String managerId) {
		return manager_repo.findById(managerId).get();
	}
	
	public void delete(String managerId) {
		manager_repo.deleteById(managerId);
	}
	public void update(Manager m) {
		List<Manager> list_manager = manager_repo.findAll();
		for(Manager mg: list_manager) {
			
			if(mg.getManagerId().equals(m.getManagerId())){
				manager_repo.save(m);
			}
			else {
			
				System.out.println("Wrong Manager Id");
			}
		}
	}

	@Override
	public Manager currentManager(String managerId) {
		
		Manager m =  manager_repo.currentManager(managerId);

		return m;
	}

	
	
	
}
