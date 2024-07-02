package com.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/GetMarksheet")
public class GetMarksheetCtl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int RollNo=Integer.parseInt(req.getParameter("rollNo"));
		Marksheet_bean bean= new Marksheet_bean();
		Marksheet_Modal mb =new Marksheet_Modal();
		
		
		try {
			 bean =mb.GetByRollNo(RollNo);
			 if(bean!=null){
			RequestDispatcher rd = req.getRequestDispatcher("GetMarksheet.jsp");
			req.setAttribute("user", bean);
			
			rd.forward(req, resp);
			 }else{
				 RequestDispatcher rd = req.getRequestDispatcher("GetMarksheet.jsp"); 
				 req.setAttribute("err", "RollNO NOT FOUND");
				 rd.forward(req, resp);
				 
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
