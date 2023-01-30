package com.finance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity

public class LoanAuthority {

	@Id
	private String loanAuth_Id;
	private String loanAuth_name;
	@Email(regexp="^(.+)@(.+)$", message="Enter valid email")
	private String loanAuth_email;
	private String loanAuth_address;
	private Long loanAuth_phoneNumber;
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15}" , message="Password must contain 1 uppercase, lowercase, number and special character")
	private String loanAuth_password;
	private String loanAuth_department;
	

	
	public LoanAuthority() {
		
	}

	public LoanAuthority(String loanAuth_Id, String loanAuth_name, String loanAuth_email, String loanAuth_address,
			Long loanAuth_phoneNumber, String loanAuth_password, String loanAuth_department) {
		super();
		this.loanAuth_Id = loanAuth_Id;
		this.loanAuth_name = loanAuth_name;
		this.loanAuth_email = loanAuth_email;
		this.loanAuth_address = loanAuth_address;
		this.loanAuth_phoneNumber = loanAuth_phoneNumber;
		this.loanAuth_password = loanAuth_password;
		this.loanAuth_department = loanAuth_department;
	}

	public String getLoanAuth_Id() {
		return loanAuth_Id;
	}

	public void setLoanAuth_Id(String loanAuth_Id) {
		this.loanAuth_Id = loanAuth_Id;
	}

	public String getLoanAuth_name() {
		return loanAuth_name;
	}

	public void setLoanAuth_name(String loanAuth_name) {
		this.loanAuth_name = loanAuth_name;
	}

	public String getLoanAuth_email() {
		return loanAuth_email;
	}

	public void setLoanAuth_email(String loanAuth_email) {
		this.loanAuth_email = loanAuth_email;
	}

	public String getLoanAuth_address() {
		return loanAuth_address;
	}

	public void setLoanAuth_address(String loanAuth_address) {
		this.loanAuth_address = loanAuth_address;
	}

	public Long getLoanAuth_phoneNumber() {
		return loanAuth_phoneNumber;
	}

	public void setLoanAuth_phoneNumber(Long loanAuth_phoneNumber) {
		this.loanAuth_phoneNumber = loanAuth_phoneNumber;
	}

	public String getLoanAuth_password() {
		return loanAuth_password;
	}

	public void setLoanAuth_password(String loanAuth_password) {
		this.loanAuth_password = loanAuth_password;
	}

	public String getLoanAuth_department() {
		return loanAuth_department;
	}

	public void setLoanAuth_department(String loanAuth_department) {
		this.loanAuth_department = loanAuth_department;
	}
	
	
}
