package com.finance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity

public class Manager {

	@Id
	@Column(name="managerid")
	private String managerId;
	private String m_name;
	@Email(regexp="^(.+)@(.+)$", message="Enter valid email")
	private String m_email;
	private String m_address;
	private Long m_phoneNumber;

	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15}" , message="Password must contain 1 uppercase, lowercase, number and special character")
	private String m_password;


	
	public Manager() {

	}

	public Manager(String managerId, String m_name, String m_email, String m_address, Long m_phoneNumber,
			String m_password) {
		super();
		this.managerId = managerId;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_address = m_address;
		this.m_phoneNumber = m_phoneNumber;
		this.m_password = m_password;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public Long getM_phoneNumber() {
		return m_phoneNumber;
	}

	public void setM_phoneNumber(Long m_phoneNumber) {
		this.m_phoneNumber = m_phoneNumber;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

}