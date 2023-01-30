package com.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.finance.model.AdminModel;

public interface AdminRepository extends JpaRepository<AdminModel,String>{
	
	@Query("from AdminModel where adminUsername=:adminUsername AND adminPassword=:adminPassword")
	public AdminModel validateAdmin(@Param(value="adminUsername")String adminUsername,@Param(value="adminPassword")String adminPassword);


}
