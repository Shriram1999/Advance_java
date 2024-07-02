package com.raystech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class testCallableStatement {
	public static void main(String[] args) throws Exception {
		testcallable();
	
	}

	public static void testcallable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		  	CallableStatement cal= conn.prepareCall("{call empcountss(?,?)}");
		  	cal.setInt(1, 1);
		  	cal.registerOutParameter(2, Types.VARCHAR);
		  	cal.execute();
		  	System.out.println(cal.getString(2));
		
	}

	/*public static void testcallable() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		  
	    CallableStatement cal =conn.prepareCall("{call empCounts(?)}");
	    
	    cal.registerOutParameter(1, Types.INTEGER);
	    cal.execute();
	    System.out.println(cal.getInt(1));
		
	}*/

}
