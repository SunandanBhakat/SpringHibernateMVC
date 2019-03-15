package com.pack;

import java.sql.CallableStatement;
import java.sql.Connection;

public class MainXS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//procedure rerturns a value but a function doesnt return a value.
		try
		{
			Connection con=JDBCConnection.getConnection();
			CallableStatement cs=con.prepareCall("{call sample(?,?,?,?)}");
			cs.setInt(1, 104431);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.registerOutParameter(3,java.sql.Types.FLOAT);
			cs.registerOutParameter(4,java.sql.Types.VARCHAR);
			cs.execute();
			System.out.println(cs.getString(2)+" "+cs.getFloat(3)+" "+cs.getString(4));
			con.close();
			
		}
		catch(Exception e){
			
		}
	}

}
