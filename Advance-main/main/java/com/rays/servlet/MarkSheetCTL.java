package com.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/MarksheetCtll")
public class MarkSheetCTL extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	Marksheet_bean bean = new Marksheet_bean();
	int RollNo=Integer.parseInt(request.getParameter("RollNo"));
	String Fname = request.getParameter("Fname");
	String Lname=request.getParameter("Lnme");
	int physics=Integer.parseInt(request.getParameter("physics"));
	int chemistry=Integer.parseInt(request.getParameter("chemistry"));
	int maths=Integer.parseInt(request.getParameter("Maths"));
	
	bean.setRollNo(RollNo);
	bean.setFname(Fname);
	bean.setLname(Lname);
	
	bean.setPhy(physics);
	bean.setChem(chemistry);
	bean.setMath(maths);
	String op = request.getParameter("operation");
	Marksheet_Modal mm = new Marksheet_Modal();
	
	if (Fname.equals("") && (Lname.equals(""))){
		RequestDispatcher rd = request.getRequestDispatcher("Marksheet.jsp");
		request.setAttribute("one", "INTER FNAME AND LNAME");
		rd.forward(request, response);
	}else if (Fname.equals("")){
		RequestDispatcher rd = request.getRequestDispatcher("Marksheet.jsp");
		request.setAttribute("two", " FNAME IS REQUIRD");
		rd.forward(request, response);
		
	}else if (Lname.equals("")){
		RequestDispatcher rd = request.getRequestDispatcher("Marksheet.jsp");
		request.setAttribute("three", " LNAME IS REQUIRD");
		rd.forward(request, response);
		
	}else {
		
	}
	
	try {
		if(op.equals("Save")){
		if(bean!=null){
		System.out.println("first");
		mm.add(bean);
		  RequestDispatcher rs = request.getRequestDispatcher("Marksheet.jsp");
		  System.out.println("first");
		  request.setAttribute("msg", "Done");
		  rs.forward(request, response);
		}else {
			 RequestDispatcher rs = request.getRequestDispatcher("Marksheet.jsp");
			 System.out.println("second");
			 request.setAttribute("Error", "Invalid Username & password");
			 rs.forward(request, response);
		} 
		}else if(op.equals("update")){
		mm.update(bean);
		RequestDispatcher rs = request.getRequestDispatcher("Marksheet.jsp");
			request.setAttribute("msg", "Done");
			rs.forward(request, response);
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}

}
