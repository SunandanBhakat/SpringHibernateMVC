package com.pack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.HibernateUtil;
import com.pack.JDBCConnection;
import com.pack.model.Employee;

public class EmployeeDAO {
	public static void insertEmployee(Employee e) throws Exception {
		/*
		 * Connection con=JDBCConnection.getConnection(); PreparedStatement
		 * ps=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		 * ps.setInt(1, e.getId()); ps.setString(2, e.getName()); ps.setFloat(3,
		 * e.getSalary()); java.sql.Date d1=new
		 * java.sql.Date(e.getDob().getTime()); ps.setDate(4, d1);
		 * ps.setString(5,e.getDesignation()); int i=ps.executeUpdate();
		 * 
		 * con.close(); return i;
		 */

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {

			t = s.beginTransaction();
			s.save(e);
			System.out.println("Employee Added Successfully!!");
			t.commit(); // Successful transaction needs commit
		}

		catch (HibernateException ex) {
			System.out.println(ex);
			t.rollback(); // if transaction fails Rollback to be done
		} finally {
			s.close(); // session has to be closed to increase performance
		}

	}

	public static void updateEmployee(Employee e) throws Exception {

		Session s = HibernateUtil.getSessionFactory().openSession();

		Transaction t = null;
		try {

			t = s.beginTransaction();
			String hql1 = "UPDATE Employee e1 SET(e1.salary=:sal,e1.designation=:des) WHERE e1.id=:eid";
			Query q = s.createQuery(hql1);
			q.setParameter("sal", e.getSalary());
			q.setParameter("des", e.getDesignation());
			q.setParameter("eid", e.getId());

			int i = q.executeUpdate();
			if (i == 1) {
				System.out.println("Updated Successfully");
				t.commit();
			}

			/*
			 * String hql="From Employee e where e.id=:eid"; //taking input from
			 * Persistent Class
			 * 
			 * Query q=s.createQuery(hql); q.setInteger("eid", e.getId());
			 * 
			 * Employee e1=(Employee) q.uniqueResult();
			 * e1.setSalary(e.getSalary());//e1 set to e
			 * e1.setDesignation(e.getDesignation());
			 * e1.setSalary(e.getSalary());
			 * 
			 * s.update(e1);//update using session
			 */

			// t.commit(); // Successful transaction needs commit
		}

		catch (HibernateException ex) {
			System.out.println(ex);
			t.rollback(); // if transaction fails Rollback to be done
		} finally {
			s.close(); // session has to be closed to increase performance
		}

	}

	public static void deleteEmployee(Employee e) throws Exception {

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = null;
		try {

			t = s.beginTransaction();
			String hql = "DELETE FROM Employee e WHERE e.id=?";
			Query q = s.createQuery(hql);
			q.setParameter(0, e.getId());

			int i = q.executeUpdate();
			if (i == 1) {
				System.out.println("Deleted Successfully");
				t.commit();
			}

		}

		catch (HibernateException ex) {
			System.out.println(ex);
			t.rollback(); // if transaction fails Rollback to be done
		} finally {
			s.close(); // session has to be closed to increase performance
		}

	}

	public static List<Employee> fetchEmployee() throws Exception {

		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Employee> l = null;
		Transaction t = null;
		try {

			t = s.beginTransaction();

			Query q = s.createQuery("FROM Employee");
			l = q.list();

			
		}

		catch (HibernateException ex) {
			System.out.println(ex);
			t.rollback(); // if transaction fails Rollback to be done
		} finally {
			s.close(); // session has to be closed to increase performance
		}
		
		
		return l;

	}

}
