package com.pack.model;


import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Employee")
public class Employee 
{
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="emp_name")
	private String name;
	private float salary;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dob;
	private String designation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employee(int id, String name, float salary, Date dob, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
		this.designation = designation;
	}
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, float salary, String designation) {
		super();
		this.id = id;
		this.salary = salary;
		this.designation = designation;
	}
	

}
