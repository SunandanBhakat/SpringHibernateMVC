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
			Student student=new Student();
			student.setStudentId(20);
			student.setStudentName("Sunandan Bhakat");
			student.setGroup("my-group");
			
			Address address=new Address();
			address.setAddressId(25);
			
			address.setPlace("Kolkata");
			address.setStudent(student);
			session.save(address);
			
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
