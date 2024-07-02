package com.rays.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Marksheet_Modal {

	public static Integer nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
		
		int pk=0;
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			pk=rs.getInt(1);
		}
		
		
		return pk+1;
		
	} 
	
	
	public void add(Marksheet_bean bean) throws Exception {
	   	 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
	
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement("insert into markSheet values(?,?,?,?,?,?,?)");
			
			
			int id= nextPK();
			ps.setInt(1, id);
			ps.setInt(2,bean.getRollNo());
			ps.setString(3,bean.getFname());
			ps.setString(4,bean.getLname());
			ps.setInt(5,bean.getPhy());
			ps.setInt(6,bean.getChem());
			ps.setInt(7,bean.getMath());
			
			
			ps.executeUpdate();
			conn.commit();
			ps.close();
			conn.close();
			
	}
	public Marksheet_bean GetByRollNo(int RollNo) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
		
		Marksheet_bean bean = null;
		PreparedStatement ps = conn.prepareStatement("select * from Marksheet where RollNo=?");
		ps.setInt(1, RollNo);
		      ResultSet rs=ps.executeQuery();
		  	
				while (rs.next()) {
					 bean = new Marksheet_bean();
					bean.setId(rs.getInt(1));
					bean.setRollNo(rs.getInt(2));
					bean.setFname(rs.getString(3));
					bean.setLname(rs.getString(4));
					bean.setPhy(rs.getInt(5));
					bean.setChem(rs.getInt(6));
					bean.setMath(rs.getInt(7));
		
				}
		return bean;
		
	}
	public List GetMarksheetList(Marksheet_bean bean) throws Exception {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
		
			ArrayList list= new ArrayList();
			PreparedStatement ps= conn.prepareStatement("select * from marksheet ");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				 bean = new Marksheet_bean();
				bean.setId(rs.getInt(1));
				bean.setRollNo(rs.getInt(2));
				bean.setFname(rs.getString(3));
				bean.setLname(rs.getString(4));
				bean.setPhy(rs.getInt(5));
				bean.setChem(rs.getInt(6));
				bean.setMath(rs.getInt(7));
				list.add(bean);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		}
	public void Delete(Marksheet_bean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");

		
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id=?");
		ps.setInt(1,bean.getId());
		
		ps.executeUpdate();
		
		conn.close();
		ps.close();

	}
	public List search(Marksheet_bean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
		
		List list = new ArrayList();
		StringBuffer sb= new StringBuffer("select * from marksheet where 1=1");
		if(bean!=null){
			if(bean.getId()>0){
				sb.append(" AND id = "+bean.getId());
			}
			if(bean.getRollNo()>0){
				sb.append(" AND RollNo = "+bean.getRollNo());	
			}
			
			if(bean.getFname()!=null && bean.getFname().length()>0){
				sb.append(" AND fname like '"+bean.getFname()+"%'");	
			}
			if(bean.getLname()!=null && bean.getLname().length()>0){
				sb.append(" AND Lname like '"+bean.getLname()+"%'");	
			}
			}
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		ResultSet rs =ps.executeQuery();
		while (rs.next()) {
			bean= new Marksheet_bean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChem(rs.getInt(6));
			bean.setMath(rs.getInt(7));
			
			list.add(bean);
		}
		conn.close();
		ps.close();
		rs.close();
		return list;
		}
	public void update(Marksheet_bean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");
				conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("update marksheet set RollNo=? , fname=? , Lnme =? , physics=? , chemistry=? , Maths=? where id=?");
		ps.setInt(1, bean.getRollNo());
		ps.setString(2,bean.getFname());
		ps.setString(3,bean.getLname());
		ps.setInt(4,bean.getPhy());
		ps.setInt(5,bean.getChem());
		ps.setInt(6,bean.getMath());
		ps.setInt(7,bean.getId());
		
		ps.executeUpdate();
		conn.commit();
		conn.close();
		ps.close();
	}
}
