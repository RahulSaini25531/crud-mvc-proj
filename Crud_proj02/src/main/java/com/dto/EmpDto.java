package com.dto;

public class EmpDto {
	
	private String fullName;
	private String address;
	private String email;
	private String password;
	private String designation;
	private String salary;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [fullName=" + fullName + ", address=" + address + ", email=" + email + ", password="
				+ password + ", designation=" + designation + ", salary=" + salary + "]";
	}
	public EmpDto(String fullName, String address, String email, String password, String designation, String salary) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.password = password;
		this.designation = designation;
		this.salary = salary;
	}
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
