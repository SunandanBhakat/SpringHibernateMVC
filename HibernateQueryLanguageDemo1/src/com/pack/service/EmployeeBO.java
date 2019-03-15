package com.pack.service;
import java.util.*;
import com.pack.DAO.EmployeeDAO;
import com.pack.model.Employee;

public class EmployeeBO 
{
	public static void insertEmployee(Employee e)throws Exception
	{
		EmployeeDAO.insertEmployee(e);
		
		
	}
	
	public static void updateEmployee(Employee e)throws Exception
	{
		EmployeeDAO.updateEmployee(e);
		
	}
	
	public static void deleteEmployee(Employee e)throws Exception
	{
		EmployeeDAO.deleteEmployee(e);
		
	}
	
	public static List<Employee> fetchEmployee()throws Exception
	{
		List<Employee> l=EmployeeDAO.fetchEmployee();
		return l;
	}
}
