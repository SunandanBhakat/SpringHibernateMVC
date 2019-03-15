package com.pack;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfiguration cfg=(AnnotationConfiguration) new AnnotationConfiguration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=null;
		
		try{
			
			t= s.beginTransaction();
			Employee e1=new Employee();
			e1.setName("Sunandan");
			
			Regular_Employee r=new Regular_Employee();
			r.setName("Rakesh");
			r.setSalary(2000);
			r.setBonus(5000);
			
			Contract_Employee c=new Contract_Employee();
			c.setName("Suresh");
			c.setPay_hour(20);
			c.setContract_duration("30");
			
			s.persist(e1);
			s.persist(r);
			s.persist(c);
			
			t.commit();     // Successful transaction needs commit
			
			System.out.println("Employee Added Successfully!!");
		}
		
		catch(HibernateException ex)
		{
			System.out.println(ex);
			t.rollback();  //if transaction fails Rollback to be done
		}
		finally
		{
			s.close();   //session has to be closed to increase performance
		}
		

	}

}
