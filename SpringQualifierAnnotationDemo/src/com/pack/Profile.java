package com.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	
	@Autowired
	@Qualifier("student1")
	private Student student;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Inside Profile Constructor");
	}
	
	public void showAge()
	{
		System.out.println(student.getAge());
		
	}
	
	public void showName()
	{
		
		System.out.println(student.getName());
	}
	
	

	
	

}
