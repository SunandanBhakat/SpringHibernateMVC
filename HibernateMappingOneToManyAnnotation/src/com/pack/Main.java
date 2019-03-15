package com.pack;

import java.util.HashSet;
import java.util.Set;

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
			Vendor vendor=new Vendor();
			vendor.setVendorId(13);
			vendor.setvName("AKash");
			
			Customer customer=new Customer();
			customer.setId(30);
			customer.setName("Ramesh");
			
			Customer customer2=new Customer();
			customer2.setId(35);
			customer2.setName("Suresh");
			
			Set<Customer> set=new HashSet<>();
			set.add(customer);
			set.add(customer2);
			
			vendor.setCustomerSet(set);
			session.save(vendor);
			
			
			
			
			
			
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
