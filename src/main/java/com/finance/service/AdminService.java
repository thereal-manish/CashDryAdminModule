package com.finance.service;

import com.finance.model.AdminModel;

public interface AdminService  {
	
	public AdminModel retrieveAdmin(String adminUsername,String adminPassword);
	public boolean authenticateAdmin(String adminUsername,String adminPassword);
	
}
