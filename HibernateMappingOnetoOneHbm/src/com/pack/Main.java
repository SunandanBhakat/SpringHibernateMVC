package com.pack;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction t= null;
		try{
			
			t= session.beginTransaction();
			Employee employee=new Employee();
			employee.setName("Sunandan Bhakat");
			
			Address address=new Address();
			address.setAddress("Kolkata");
			address.setCountry("India");
			
			employee.setAddress(address);
			
			session.save(employee);
			
			System.out.println("Success");
			
			t.commit();     
		}
		
		catch(HibernateException ex)
		{
			System.out.println(ex);
			t.rollback();  //if transaction fails Rollback to be done
		}
		finally
		{
			session.close();   //session has to be closed to increase performance
		}
		

	}

}
