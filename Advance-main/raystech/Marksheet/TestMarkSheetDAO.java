package com.raystech.Marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMarkSheetDAO {
	
  static	MarkSheetDAO dao= new MarkSheetDAO();
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testDelete();
		//testupdate();
		
		//testgetMeritlist();
	    testGetList();
		//testGetByRollNo();
		//testSearch();
	}
	public static void testSearch() throws Exception {
		MarkSheetBean bean = new MarkSheetBean();
		List list= new ArrayList();
		//bean.setId(1);
		bean.setRollNo(115);
		//bean.setFname("AA");
		list= dao.search(bean);
		
		Iterator it = list.iterator();
		
	while (it.hasNext()) {
		  bean = (MarkSheetBean)it.next();
			System.out.print("\t"+bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getFname());
			System.out.print("\t"+bean.getLname());
			System.out.print("\t"+bean.getPhy());
			System.out.print("\t"+bean.getChem());
			System.out.println("\t"+bean.getMath());
			
				
	}
	
		
	}
	public static void testGetByRollNo() throws Exception {
		MarkSheetBean bean =dao.GetByRollNo(101);
		System.out.print("\t"+bean.getId());
		System.out.print("\t"+bean.getRollNo());
		System.out.print("\t"+bean.getFname());
		System.out.print("\t"+bean.getLname());
		System.out.print("\t"+bean.getPhy());
		System.out.print("\t"+bean.getChem());
		System.out.println("\t"+bean.getMath());
		System.out.println();
		
	}
	public static void testGetList() throws Exception {
		MarkSheetBean bean = new MarkSheetBean();
		List list= new ArrayList();  
		list = dao.GetList(bean);

		Iterator it = list.iterator();
		
	while (it.hasNext()) {
		  bean = (MarkSheetBean)it.next();
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
	public static void testgetMeritlist() throws Exception {
		MarkSheetBean bean = new MarkSheetBean();
		List list= new ArrayList();
		list= dao.getMeritlist(bean);
		
		Iterator it = list.iterator();
		
	while (it.hasNext()) {
		  bean = (MarkSheetBean)it.next();
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
	public static void testupdate() throws Exception {
	MarkSheetBean bean = new MarkSheetBean();
	
	
	bean.setRollNo(101);
	bean.setFname("Aakash");
	bean.setLname("Rathod");
	bean.setPhy(90);
	bean.setChem(75);
	bean.setMath(91);
	bean.setId(1);
	
	
	dao.update(bean);
	
	System.out.println("record updated");
	
	}

	public static void testDelete() throws Exception {
		
		MarkSheetBean bean = new MarkSheetBean();
		bean.setId(5);
		
      
		
		dao.Delete(bean);
		
		System.out.println("record deleted");

		
	}

	public static void testAdd() throws Exception {
		
		MarkSheetBean bean = new MarkSheetBean();
		
		bean.setRollNo(115);
		bean.setFname("vishal");
		bean.setLname("Rajput");
		bean.setPhy(52);
		bean.setChem(52);
		bean.setMath(45);
		
		
		
		dao.add(bean);
		
		System.out.println("INSERTED");
		
	}
	
	

}
