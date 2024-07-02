package com.raystech.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Callablefunctionstatm {
public static void main(String[] args) throws Exception {
	
	testcallable();
}

public static void testcallable() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
	  
    CallableStatement cal =conn.prepareCall("{?=call empcount()}");
    
    cal.registerOutParameter(1, Types.INTEGER);
    cal.execute();
    System.out.println(cal.getInt(1));
	
}

}

