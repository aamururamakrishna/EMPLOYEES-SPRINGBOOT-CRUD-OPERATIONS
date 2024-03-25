package com.company.employees.models;

import jakarta.validation.constraints.NotEmpty;

public class EmployeeDto {

	@NotEmpty(message = "This field is required")
	private String emailid;
	
	@NotEmpty(message = "The field is required")
	private String employeeid;
	
	@NotEmpty(message = "The field is required")
	private String location;
	
	@NotEmpty(message = "The field is required")
	private String mobileno;
	
	@NotEmpty(message = "The field is required")
	private String name;
	
	@NotEmpty(message = "The field is required")
	private String technology;

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	
	/* Generate : Getters and Setters

 	***How to Generate?***
	step-1: Right click select source click on getters and setters and select all and click on generate. */
	

	
	
}
