package com.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.model.AdminModel;
import com.finance.repository.AdminRepository;

@Service
public class AdminModelServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;


	@Override
	public AdminModel retrieveAdmin(String adminUsername, String adminPassword) {
		AdminModel adminModel = adminRepo.validateAdmin(adminUsername, adminPassword);
		return adminModel;
	}

	@Override
	public boolean authenticateAdmin(String adminUsername, String adminPassword) {
		AdminModel adminModel = adminRepo.validateAdmin(adminUsername, adminPassword);
		if (adminModel == null) {
			return false;
		}
		return true;

	}

}
