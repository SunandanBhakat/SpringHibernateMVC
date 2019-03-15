package com.pack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import com.pack.model.Employee;
import com.pack.service.EmployeeBO;

public class Main {

	public static void main(String[] args)throws Exception
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("#### Employee Info####");
		System.out.println("Menu");
		System.out.println("1. Add Employee");
		System.out.println("2. Update");
		System.out.println("3. Delete Employee");
		System.out.println("4. View Employee");
		System.out.println("5. Exit Program");
		int ch;
		
				
		do
		{
			System.out.println("Enter choice");
			ch=Integer.parseInt(sc.nextLine());
			
			switch(ch)
			{
			case 1: insert();
					break;
			case 2: update();
					break;
			case 3: delete();
					break;
			case 4:	view();
					break;
					
			case 5: System.out.println("Program Terminated. Thank You for Using the System! :)");
					System.exit(0);
					break;
			}
		}while(ch<5);
		
		
		
	}
	
	public static void insert()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		String name,dob,desg;
		float sal;
		int num;
		
		System.out.println("Enter the Employee Name");
		name=sc.nextLine();
		System.out.println("Enter Salary");
		sal=Float.parseFloat(sc.nextLine());
		System.out.println("Enter DOB");
		dob=sc.nextLine();
		System.out.println("Enter Designation");
		desg=sc.nextLine();
		Random x=new Random();
		num=x.nextInt(9000)+100000;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		Date d=null;
		
		try{
			d=sdf.parse(dob);
		}
		catch(ParseException e)
		{
			System.out.println(e);
		}
		
		Employee e=new Employee(num,name,sal,d,desg);
		EmployeeBO.insertEmployee(e);
		
	}
	
	
	public static void update()throws Exception
	{
		Scanner s=new Scanner(System.in);
		int num;
		float sal;
		String desg;
		
		System.out.println("Enter Emp Id:");
		num=Integer.parseInt(s.nextLine());
		System.out.println("Enter employee salary");
		sal=Float.parseFloat(s.nextLine());
		System.out.println("Enter the designation");
		desg=s.nextLine();
		
		Employee e1=new Employee(num,sal,desg);
		EmployeeBO.updateEmployee(e1);
		
		
	}
	
	public static void delete()throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int num;
		System.out.println("Enter Emp Id:");
		num=Integer.parseInt(sc.nextLine());
		
		Employee e2=new Employee(num);
		EmployeeBO.deleteEmployee(e2);
		
		
	}
	
	public static void view()throws Exception
	{
		List<Employee> l=EmployeeBO.fetchEmployee();
		System.out.format("%-10s %-25s %10s %-10s\n", "EmployeeId","Employee Name","Salary","Date of Birth","Designation");
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		for(Employee e:l)
		{
			System.out.format("%-10s %-25s %10s %-10s\n",e.getId(),e.getName(),e.getSalary(),sdf.format(e.getDob()),e.getDesignation());
			
		}
		
		
	}

}
