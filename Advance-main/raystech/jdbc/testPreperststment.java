package com.raystech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testPreperststment {    
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testupdate();
		testselect();
		//testDelete();
		//testGetById(4);
		//int i=nextPK();
		//System.out.println(i);
	}

	
	public static Integer nextPK() throws Exception {
Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		
		int pk=0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from employee");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
		}
		
		
		return pk+1;
		
	} 
	public static void testGetById(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
		
		PreparedStatement ps = conn.prepareStatement("select*from Employee where id=?");
		ps.setInt(1, id);
		ResultSet set = ps.executeQuery();
		while (set.next()) {
			System.out.print("\t" +set.getInt(1));
			System.out.print("\t" +set.getString(2));
			System.out.print("\t" +set.getString(3));
			System.out.print("\t"+set.getInt(4));
			System.out.println("\t"+set.getInt(5));
		}
		conn.close();
		ps.close();
		set.close();
		
	}

	public static void testDelete() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
			
			int id=5;
			PreparedStatement ps = conn.prepareStatement("delete from Employee where id=?");
			ps.setInt(1,id);
			
			int i = ps.executeUpdate();
			System.out.println(i+"record deleted");
			
			conn.close();
			ps.close();
		
	}

	public static void testselect() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
			PreparedStatement ps = conn.prepareStatement("select*from Employee");

			ResultSet is = ps.executeQuery();
			while (is.next()) {
				System.out.print("\t" +is.getInt(1));
				System.out.print("\t" +is.getString(2));
				System.out.print("\t" +is.getString(3));
				System.out.print("\t"+is.getInt(4));
				System.out.println("\t"+is.getInt(5));

			}
			conn.close();
			ps.close();
			is.close();
	}

	public static void testupdate() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
			
			int id=12;
			String fname="Abhshek";
			String lname ="Varma";
			int selery=75000;
			int DEPT_id=5;
			
			PreparedStatement ps = conn.prepareStatement("update employee set fname=? , lname =? , selery=? , DEPT_ID=? where id=?");
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setInt(3, selery);
			ps.setInt(4, DEPT_id);
			ps.setInt(5, id);
			int i = ps.executeUpdate();
			System.out.println(i+"record updated");
			
			conn.close();
			ps.close();
		
	}

	public static void testAdd() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/hellorays","root","root");
			
			//int id=13;
			int id=nextPK();
			String fname="shourabh";
			String lname ="Rajput";
			int selery=65000;
			int DEPT_id=5;
			
			PreparedStatement ps = conn.prepareStatement("insert into Employee values(?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setInt(4, selery);
			ps.setInt(5, DEPT_id);
			
			int i = ps.executeUpdate();
			System.out.println(i+"Inserted");
			
			conn.close();
			ps.close();
	}

}
