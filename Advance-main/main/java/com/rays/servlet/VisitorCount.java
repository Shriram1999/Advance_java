package com.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/VisitororCount")
public class VisitorCount extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext app = getServletContext();
		resp.setIntHeader("Refresh", 1);

		Integer count = (Integer)app.getAttribute("visitcount");
		if (count == null){
			count = 1;
		}else {
			count++;
		}
		app.setAttribute("visitcount", count);
		PrintWriter out = resp.getWriter();
		out.println("visitore "+count);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
