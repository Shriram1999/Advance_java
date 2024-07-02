package com.raystech.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarkSheetDAO {
	
	
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
	
	
	public void add(MarkSheetBean bean) throws Exception {
	   /*	 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");*/
		ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
		 Class.forName(rb.getString("driver"));
			
			Connection conn =DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
		
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
	public void Delete(MarkSheetBean bean) throws Exception {
		/* Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");*/
		ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
		 Class.forName(rb.getString("driver"));
			
			Connection conn =DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
			
			
			PreparedStatement ps = conn.prepareStatement("delete from marksheet where id=?");
			ps.setInt(1,bean.getId());
			
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		
	}
	public void update(MarkSheetBean bean) throws Exception {
		/*Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");*/
		ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
		 Class.forName(rb.getString("driver"));
			
			Connection conn =DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
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
	public List GetList(MarkSheetBean bean) throws Exception {
		
	/*	Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");*/
		ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
		 Class.forName(rb.getString("driver"));
			
			Connection conn =DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
		ArrayList list= new ArrayList();
		PreparedStatement ps= conn.prepareStatement("select * from marksheet");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			 bean = new MarkSheetBean();
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
	public List getMeritlist(MarkSheetBean bean) throws Exception {
		/*Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");*/
		ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
		 Class.forName(rb.getString("driver"));
			
			Connection conn =DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
		ArrayList list= new ArrayList();
		PreparedStatement ps = conn.prepareStatement("select * ,(physics+chemistry+maths) As Total from marksheet where physics>40 and chemistry>40 and maths>40 order by Total desc limit 10");
	
		ResultSet rs =ps.executeQuery();
		
		
		while (rs.next()) {
			 bean = new MarkSheetBean();
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
	
		public MarkSheetBean GetByRollNo(int RollNo) throws Exception {
		
	/*	Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");*/
			ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
			 Class.forName(rb.getString("driver"));
				
				Connection conn =DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
		
		MarkSheetBean bean = null;
		PreparedStatement ps = conn.prepareStatement("select * from Marksheet where RollNo=?");
		ps.setInt(1, RollNo);
		      ResultSet rs=ps.executeQuery();
		  	
				while (rs.next()) {
					 bean = new MarkSheetBean();
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
		public List search(MarkSheetBean bean) throws Exception {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/sky","root","root");*/
			ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
			 Class.forName(rb.getString("driver"));
				
				Connection conn =DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
			List list = new ArrayList();
			StringBuffer sb= new StringBuffer("select * from marksheet where 1=1");
			if(bean!=null){
				if(bean.getId()>0){
					sb.append(" AND id ="+bean.getId());
				}
				if(bean.getRollNo()>0){
					sb.append(" AND RollNo like '"+bean.getRollNo()+"%'");		
				}
				
				if(bean.getFname()!=null && bean.getFname().length()>0){
					sb.append(" AND Fname like '"+bean.getFname()+"%'");	
				}
				if(bean.getLname()!=null && bean.getLname().length()>0){
					sb.append(" AND Lnme like '"+bean.getLname()+"%'");	
				}
				}
			PreparedStatement ps = conn.prepareStatement(sb.toString());
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				bean= new MarkSheetBean();
				bean.setId(rs.getInt(1));
				bean.setRollNo(rs.getInt(2));
				bean.setFname(rs.getString(3));
				bean.setLname(rs.getString(4));
				bean.setPhy(rs.getInt(2));
				bean.setChem(rs.getInt(2));
				bean.setMath(rs.getInt(2));
				list.add(bean);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
			}
			
		}
		
		
		
		
		
		
		
		
		

