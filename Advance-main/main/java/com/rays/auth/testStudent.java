package com.rays.auth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class testStudent {
	static StudentModal sm = new StudentModal();
	public static void main(String[] args) throws Exception {
		//Add();
		//update();
		//delete();
	  // getbyrollNo();
	  // testSearch();
	   testGetList();
	}
	
	public static void testGetList() throws Exception {
			StudentBean bean = new StudentBean();
		List list= new ArrayList();  
		list = sm.GetList(bean);

		Iterator it = list.iterator();
		
	while (it.hasNext()) {
		  bean = (StudentBean)it.next();
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.println("\t"+bean.getSession());
			
			System.out.println();
				
	}
	
		
	}
	public static void testSearch() throws Exception {
		StudentBean bean = new StudentBean();
		List list= new ArrayList();
		//bean.setId(1);
		bean.setRollNo("101");
		//bean.setFname("AA");
		list= sm.search(bean);
		Iterator it = list.iterator();
		
	while (it.hasNext()) {
		  bean = (StudentBean)it.next();
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getSession());
			
			
				
	}
	
		
	}

	public static void getbyrollNo() throws Exception {
		
			StudentBean bean =sm.GetByRollNo("101");
			
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getFirstName());
			System.out.print("\t"+bean.getLastName());
			System.out.print("\t"+bean.getSession());
			
			
		
	}


	public static void delete() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setId(7);
		
		sm.Delete(bean);
		System.out.println("DELETED");
	}

	public static void update() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setRollNo("106");
		bean.setFirstName("Viju");
		bean.setLastName("mehta");
		bean.setSession("2020-21");
		bean.setId(6);
		sm.update(bean);
		System.out.println("UPDASTED");
		
	}

	public static void Add() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setRollNo("106");
		bean.setFirstName("Vijay");
		bean.setLastName("Seth");
		bean.setSession("2020-21");
		sm.add(bean);
		
		System.out.println("INSERTED");
		
	}
}
