package com.rays.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/GetmarksheetCTL")
public class GetMarksheetlistCtl extends HttpServlet {
	
    
        
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Marksheet_bean bean = new Marksheet_bean();
		Marksheet_Modal dao = new Marksheet_Modal();
		
		try {
			List list =dao.GetMarksheetList(bean);
			RequestDispatcher rd = request.getRequestDispatcher("MarksheetList.jsp");
			request.setAttribute("lst", list);
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Marksheet_bean bean = new Marksheet_bean();
		Marksheet_Modal dao = new Marksheet_Modal();
		 bean.setFname(request.getParameter("name"));
		bean.setRollNo(Integer.parseInt(request.getParameter("rollNo")));	
		
		String op = request.getParameter("operation");
		if(op.equals("Search")){
			try {
				List list = dao.search(bean);
				RequestDispatcher rd = request.getRequestDispatcher("MarksheetList.jsp");
				request.setAttribute("lst", list);
				rd.forward(request, response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(op.equals("New")){
			RequestDispatcher rd = request.getRequestDispatcher("Marksheet.jsp");
			rd.forward(request, response);
			
			
		}else if(op.equals("Delete")) {
			
		}
	}

}
