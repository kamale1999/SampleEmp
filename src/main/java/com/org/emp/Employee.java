package com.org.emp;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee", schema = "public")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String ename;
	private String department;
	private Date doj;
	private String address;
	private String stateAndCity;
	
	public Employee() {
	}

	public Employee(Integer id, String ename, String department, Date doj, String address, String stateAndCity) {
		super();
		this.id = id;
		this.ename = ename;
		this.department = department;
		this.doj = doj;
		this.address = address;
		this.stateAndCity = stateAndCity;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStateAndCity() {
		return stateAndCity;
	}

	public void setStateAndCity(String stateAndCity) {
		this.stateAndCity = stateAndCity;
	}
	
	
	
	
}
