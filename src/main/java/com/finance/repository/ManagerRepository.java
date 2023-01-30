package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.model.Manager;


public interface ManagerRepository extends JpaRepository<Manager, String>{
	
	@Query("from Manager where managerid=:manager_Id")
	public Manager currentManager(@Param(value="manager_Id") String managerId) ;
	
}
