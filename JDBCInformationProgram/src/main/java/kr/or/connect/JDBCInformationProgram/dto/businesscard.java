package kr.or.connect.JDBCInformationProgram.dto;

import java.sql.Timestamp;

public class businesscard {
	private String name;
	private String phone;
	private String company;
	private Timestamp register;
	
	public businesscard(String name, String phone, String company, Timestamp register) {
		super();
		this.name = name;
		this.phone = phone;
		this.company = company;
		this.register = register;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Timestamp getRegister() {
		return register;
	}
	public void setRegister(Timestamp register) {
		this.register = register;
	}
	@Override
	public String toString() {
		return "BusinessCard [name=" + name + ", phone=" + phone + ", company=" + company + ", createDate=" + register
				+ "]";
	}
}
