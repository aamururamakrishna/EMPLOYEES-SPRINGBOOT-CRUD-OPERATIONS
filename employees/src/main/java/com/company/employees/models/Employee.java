package com.company.employees.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")  //DataBase Table Name
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String employeeid;  
	private String emailid;
	private String location;
	private String mobileno;
	private String name;
	private String technology;
	
	/* Generate : Getters and Setters, Constructors using fields , constructors from superclass and tostring();
		***How to Generate?***
	step-1: Right click select source click on getters and setters and select all and click on generate.
	step-2: Right click select source click on Constructors using fields and click on generate.
	step-3: Right click select source click on Constructors from superclass and click on generate.
	step-4: Right click select source click on toString() and click on generate. */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
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
	public Employee(int id, String employeeid, String emailid, String location, String mobileno, String name,
			String technology) {
		super();
		this.id = id;
		this.employeeid = employeeid;
		this.emailid = emailid;
		this.location = location;
		this.mobileno = mobileno;
		this.name = name;
		this.technology = technology;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeid=" + employeeid + ", emailid=" + emailid + ", location=" + location
				+ ", mobileno=" + mobileno + ", name=" + name + ", technology=" + technology + "]";
	}
}
