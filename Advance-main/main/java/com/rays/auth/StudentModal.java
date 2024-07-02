package com.rays.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;










public class StudentModal {
	

	
	public static Integer nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
		
		int pk=0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from Student");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
		}
		
		
		return pk+1;
		
	} 
	
	
	public void add(StudentBean bean) throws Exception {
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
		
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement("insert into Student values(?,?,?,?,?)");
			
			
			int id= nextPK();
			ps.setInt(1, id);
			ps.setString(2,bean.getRollNo());
			ps.setString(3,bean.getFirstName());
			ps.setString(4,bean.getLastName());
			ps.setString(5,bean.getSession());
			
			
			ps.executeUpdate();
			conn.commit();
			ps.close();
			conn.close();
			
	}
	public void update(StudentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
			conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("update Student set RollNo=? , firstName=? , lastName =? , session=? where id=?");
		ps.setString(1, bean.getRollNo());
		ps.setString(2,bean.getFirstName());
		ps.setString(3,bean.getLastName());
		ps.setString(4,bean.getSession());
		ps.setInt(5, bean.getId());
		
		ps.executeUpdate();
		conn.commit();
		conn.close();
		ps.close();
	}
	public void Delete(StudentBean bean) throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
	
			
			PreparedStatement ps = conn.prepareStatement("delete from Student where id=?");
			ps.setInt(1,bean.getId());
			
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		
	}
	public StudentBean GetByRollNo(String rollNo) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
			
		StudentBean bean = null;
		PreparedStatement ps = conn.prepareStatement("select*from Student where rollNo=?");
		ps.setString(1, rollNo);
		      ResultSet rs=ps.executeQuery();
		  	
				while (rs.next()) {
					 bean = new StudentBean();
					bean.setId(rs.getInt(1));
					bean.setRollNo(rs.getString(2));;
					bean.setFirstName(rs.getString(3));;
					bean.setLastName(rs.getString(4));
					bean.setSession(rs.getString(5));
					
		
				}
				
		return bean;
		
	}
	public List search(StudentBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
		
		List list = new ArrayList();
		StringBuffer sb= new StringBuffer("select * from Student where 1=1");
		if(bean!=null){
			if(bean.getId()>0){
				sb.append(" AND id ="+bean.getId());
			}
			if(bean.getRollNo()!=null && bean.getRollNo().length()>0){
				sb.append(" AND RollNo like '"+bean.getRollNo()+"%'");		
			}
			
			if(bean.getFirstName()!=null && bean.getFirstName().length()>0){
				sb.append(" AND firstname like '"+bean.getFirstName()+"%'");	
			}
			if(bean.getLastName()!=null && bean.getLastName().length()>0){
				sb.append(" AND Lnme like '"+bean.getLastName()+"%'");	
			}
			}
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		ResultSet rs =ps.executeQuery();
		while (rs.next()) {
			bean= new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setFirstName(rs.getString(3));
			bean.setLastName(rs.getString(4));
			bean.setSession(rs.getString(5));
			
			list.add(bean);
		}
		conn.close();
		ps.close();
		rs.close();
		return list;
		}
	
	public List GetList(StudentBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
	
		ArrayList list= new ArrayList();
		PreparedStatement ps= conn.prepareStatement("select * from Student");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			 bean = new StudentBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setFirstName(rs.getString(3));
			bean.setLastName(rs.getString(4));
			bean.setSession(rs.getString(5));
			
			list.add(bean);
		}
		conn.close();
		ps.close();
		rs.close();
		return list;
	}
		
	}
	

