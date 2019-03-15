package com.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainEx {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		try
		
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into employee(id,ename,salary,designation) values(?,?,?,?)");
			ps.setInt(1, 10);
			ps.setString(2, "aaaa");
			ps.setFloat(3, 20000);
			ps.setString(4, "Member");
			ps.addBatch();
			ps.setInt(1, 20);
			ps.setString(2, "bbbb");
			ps.setFloat(3, 30000);
			ps.setString(4, "Trainer");
			ps.addBatch();
			ps.setInt(1, 30);
			ps.setString(2, "cccc");
			ps.setFloat(3, 40000);
			ps.setString(4, "Manager");
			ps.addBatch();
			
			int count[]=ps.executeBatch();
			
			
			/*Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select id,salary from employee");*/
			
			/*rs.absolute(2);
			System.out.println(rs.getInt(1));
			rs.absolute(3);
			System.out.println(rs.getInt(1));
			rs.first();
			System.out.println(rs.getInt(1));
			System.out.println(rs.isFirst());
			rs.last();
			System.out.println(rs.getInt(1));
			System.out.println(rs.isLast());
			rs.absolute(-1);
			System.out.println(rs.getInt(1));
			rs.absolute(-2);
			System.out.println(rs.getInt(1));
			rs.absolute(-3);
			System.out.println(rs.getInt(1));
			
			rs.updateFloat(2,1.01f);
			rs.updateRow();
			System.out.println(rs.getFloat(2));
			
			rs.absolute(2);
			rs.deleteRow();*/
			
			/*rs.moveToCurrentRow();
			rs.absolute(1);
			rs.moveToInsertRow();
			rs.updateInt(1, 12000);
			rs.updateFloat(2, 60000);
			rs.insertRow();
			rs.moveToCurrentRow();*/
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
