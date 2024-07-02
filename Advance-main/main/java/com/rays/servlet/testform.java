package com.rays.servlet;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.auth.StudentBean;







public class testform {
	

	public static void main(String[] args) throws Exception {
		// testAdd();
		//testAuth();
		//testGetByRollNo();
		// GetMarksheetList();
		testSearch();
			}

	/*
	 * public static void testAuth() { Userbean bean = new Userbean();
	 * 
	 * try { bean = mo.auth("rpziddi147@gmail.com", "254"); if (bean != null) {
	 * System.out.println("valid user"); } else {
	 * System.out.println("invalid user"); } } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

	public static void testAdd() throws Exception {
		Marksheet_bean bean = new Marksheet_bean();
		Marksheet_Modal ms = new Marksheet_Modal();
		bean.setRollNo(116);
		bean.setFname("vipul");
		bean.setLname("varma");
		bean.setPhy(54);
		bean.setChem(52);
		bean.setMath(54);
		ms.add(bean);
		
		System.out.println("dhsjdhsdj");
	}
	
	public static void testGetByRollNo() throws Exception {
		
		Marksheet_Modal ms = new Marksheet_Modal();
	Marksheet_bean bean = ms.GetByRollNo(101);
	
		System.out.print("\t"+bean.getId());
		System.out.print("\t"+bean.getRollNo());
		System.out.print("\t"+bean.getFname());
		System.out.print("\t"+bean.getLname());
		System.out.print("\t"+bean.getPhy());
		System.out.print("\t"+bean.getChem());
		System.out.println("\t"+bean.getMath());
		System.out.println();
		
	}
	public static void  GetMarksheetList() throws Exception {
		Marksheet_bean bean = new Marksheet_bean();
		Marksheet_Modal dao =new Marksheet_Modal();
		List list= new ArrayList();  
		list = dao.GetMarksheetList(bean);

		Iterator it = list.iterator();
		
	while (it.hasNext()) {
		  bean = (Marksheet_bean)it.next();
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getFname());
			System.out.print("\t"+bean.getLname());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChem());
			System.out.println("\t"+bean.getMath());
			System.out.println();
				
	}
	
		
	}
	public static void testSearch() throws Exception {
		Marksheet_bean bean =  new Marksheet_bean();
		Marksheet_Modal dao =new Marksheet_Modal();
		List list= new ArrayList();
		//bean.setId(1);
	bean.setRollNo(108);
		//bean.setFname("AA");
		list= dao.search(bean);
		Iterator it = list.iterator();
		
	while (it.hasNext()) {
		  bean = (Marksheet_bean)it.next();
			
		  System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getFname());
			System.out.print("\t"+bean.getLname());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChem());
			System.out.println("\t"+bean.getMath());
			System.out.println();
				
			
				
	}
	
		
	}
}
