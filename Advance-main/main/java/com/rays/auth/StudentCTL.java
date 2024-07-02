package com.rays.auth;

import java.io.IOException;
import java.util.List;

import javax.naming.directory.SearchResult;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.servlet.Marksheet_Modal;
import com.rays.servlet.Marksheet_bean;

@WebServlet(urlPatterns = "/StudentCTL")
public class StudentCTL extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentBean bean = new StudentBean();
		StudentModal sm = new StudentModal();
		
		/*
		 * try {
		 * 
		 * 
		 * if(op.equals("Search")){ sm.search(bean); RequestDispatcher rds =
		 * req.getRequestDispatcher("Student.jsp"); req.setAttribute("Search",bean);
		 * rds.forward(req, resp); } else {
		 * 
		 * RequestDispatcher rds = req.getRequestDispatcher("Student.jsp");
		 * rds.forward(req, resp); } } catch (Exception e) { // TODO: handle exception }
		 */
				
		try {
			
			List list =sm.GetList(bean);
			RequestDispatcher rd = req.getRequestDispatcher("Student.jsp");
			req.setAttribute("lst", list);
			rd.forward(req, resp);
			
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		StudentBean bean = new StudentBean();
		
		bean.setFirstName(req.getParameter("name"));
		bean.setRollNo(req.getParameter("rollNo"));
		StudentModal sm = new StudentModal();
		 String op = req.getParameter("operation");
		 if(op.equals("Search")){
			try {
				List list =	sm.search(bean);
				RequestDispatcher rd = req.getRequestDispatcher("Student.jsp");
				req.setAttribute("lst",list);
				rd.forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
			 
		 }
	}
	
}
