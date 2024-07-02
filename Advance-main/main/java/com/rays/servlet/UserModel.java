package com.rays.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.rays.auth.StudentBean;

public class UserModel {

	public static Integer nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sky", "root", "root");

		int pk = 0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from StudentRegistrationform");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;

	}

	public Userbean auth(String email, String password) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sky", "root", "root");
		Userbean bean = null;
		PreparedStatement ps = conn.prepareStatement("select* from StudentRegistrationform where email = ? and password = ?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			bean = new Userbean();
			
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(4));

			bean.setpassword(rs.getString(5));

		}
		/*
		 * conn.close(); ps.close();
		 */
		return bean;

	}

	public void add(Userbean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sky", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("insert into StudentRegistrationform values(?,?,?,?,?,?,?,?)");

		int id = nextPK();
		ps.setInt(1, id);
		ps.setString(2, bean.getName());
		ps.setString(3, bean.getNumber());
		ps.setString(4, bean.getEmail());

		ps.setString(5, bean.getpassword());
		ps.setString(6, bean.getGender());
		ps.setString(7, bean.getDate());
		ps.setString(8, bean.getAddress());

		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();

	}
	public Userbean forgetPass(String email) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sky", "root", "root");
		Userbean bean=null;
		PreparedStatement ps = conn.prepareStatement("select*from StudentRegistrationform where email=?");
		ps.setString(1, email);
	
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean= new Userbean();
			
		//	bean.setEmail(rs.getString(4));
			bean.setpassword(rs.getString(5));
			
		}
		return bean;
	}
	

	

}
