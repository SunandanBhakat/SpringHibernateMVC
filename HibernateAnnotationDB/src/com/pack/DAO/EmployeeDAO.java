package com.pack.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pack.HibernateUtil;
import com.pack.JDBCConnection;
import com.pack.model.Employee;

public class EmployeeDAO {
	public static void insertEmployee(Employee e)throws Exception
	{
		/*Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setFloat(3, e.getSalary());
		java.sql.Date d1=new java.sql.Date(e.getDob().getTime());
		ps.setDate(4, d1);
		ps.setString(5,e.getDesignation());
		int i=ps.executeUpdate();
		
		con.close();
		return i;*/
		
		Session s=HibernateUtil.getSessionFactory().openSession();
		Transaction t= null;
		try{
			
			t= s.beginTransaction();
			s.save(e);
			System.out.println("Employee Added Successfully!!");
			t.commit();     // Successful transaction needs commit
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

	public static void updateEmployee(Employee e)throws Exception
	{
		/*Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("update employee set salary=?,designation=? where id=?");
		ps.setFloat(1, e.getSalary());
		ps.setString(2, e.getDesignation());
		ps.setInt(3, e.getId());
		int i=ps.executeUpdate();
		con.close();
		return i;*/
		
		Session s= HibernateUtil.getSessionFactory().openSession();
		
		Transaction t= null;
		try{
			
			t=s.beginTransaction();
			int id=e.getId();
			Employee emp=(Employee)s.get(Employee.class,id);
			emp.setSalary(e.getSalary());
			emp.setDesignation(e.getDesignation());
			s.update(emp);
			System.out.println("Employee Updated Successfully");
			t.commit();     // Successful transaction needs commit
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
	
	public static void deleteEmployee(Employee e)throws Exception
	{
		/*Connection con=JDBCConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
		
		ps.setInt(1, e.getId());
		int i=ps.executeUpdate();
		con.close();*/
		
		
		Session s= HibernateUtil.getSessionFactory().openSession();
		Transaction t= null;
		try{
			
			t= s.beginTransaction();
			Employee emp=(Employee)s.get(Employee.class,e.getId());
			if(emp!=null)
			{
				s.delete(emp);
				System.out.println("Employee Deleted Successfully");
				t.commit(); // Successful transaction needs commit
			}
			    
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
	
	public static List<Employee> fetchEmployee()throws Exception
	{
		Connection con=JDBCConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from employee");
		List<Employee> l=new ArrayList<>();
		while(rs.next())
		{
			Employee e=new Employee();
			e.setId(rs.getInt(1));//1,2,3 are from select query. Otherwise refer directly to column name 
			e.setName(rs.getString(2));
			e.setSalary(rs.getFloat(3));
			java.util.Date d=new java.util.Date(rs.getDate(4).getTime());
			e.setDob(d);
			e.setDesignation(rs.getString(5));
			l.add(e);
			
		}
		return l;
	}
	
	
}
