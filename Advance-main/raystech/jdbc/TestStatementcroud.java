package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatementcroud {

	public static void main(String[] args) throws Exception{
		//testselect();
	
		
		testAdd();
		//testUpdate();
		//testDelete();
		//testGetById();
	}

	
	public static void testGetById() throws Exception {
	       Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
			
			Statement st =conn.createStatement();
		    ResultSet rs = st.executeQuery("select * from employee where id=3");
		    while (rs.next()) {
				
			
		    System.out.print("\t"+rs.getInt(1));
		    System.out.print("\t"+rs.getString(2));
		    System.out.print("\t"+rs.getString(3));
		    System.out.print("\t"+rs.getInt(4));
		    System.out.println("\t"+rs.getInt(5));
		    }
		    conn.close();
		    st.close();
		    rs.close();
	}


	public static void testUpdate() throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		
		Statement st =conn.createStatement();
		int i = st.executeUpdate("update employee set fname='krishna' , lname='Gurjar' , selery=60000 , DEPT_ID=3 where id=6");
		System.out.println(i+"record updated");
		conn.close();
		st.close();
	}
  

	public static void testAdd() throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		conn.setAutoCommit(false);

		Statement st =conn.createStatement();
		int i = st.executeUpdate("insert into employee values(15,'Deepanshu','Patel',60000,3");
		st.executeUpdate("insert into employee values(13,'Deepanshu','Patel',60000,3");
		st.executeUpdate("insert into employee values(11,'Deepanshu','Patel',60000,3");
		conn.commit();
		System.out.println(i+"inserted");
		conn.close();
		st.close();
}
	public static void testDelete() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		Statement st =conn.createStatement();
		int i =st.executeUpdate("delete from employee where id=9");
		
		System.out.println(i+ "record deleted");
		conn.close();
		st.close();
		
	}


	

	public static void testselect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		
		Statement st =conn.createStatement();
		ResultSet rs =st.executeQuery("select * from employee");
		while (rs.next()) {
			System.out.print("\t" +rs.getInt(1));
			System.out.print("\t" +rs.getString(2));
			System.out.print("\t" +rs.getString(3));
			System.out.print("\t"+rs.getInt(4));
			System.out.println("\t"+rs.getInt(5));
		
		}
		st.close();
		conn.close();
		rs.close();
	}

}
