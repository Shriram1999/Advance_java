package com.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/fdctl")
public class ForgotPasswordCtl extends HttpServlet {
	
       
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Userbean bean = new Userbean();
		UserModel um = new UserModel();
		PrintWriter out = res.getWriter();
		String email=req.getParameter("email");
		try {
			bean=um.forgetPass(email);
			if(bean!=null){
				//out.println("Your Email id is :"+bean.getEmail());
				out.println("Your Password is :"+bean.getpassword());
			}else if(email.equals("")){
				
				RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword.jsp");
				req.setAttribute("email", "Please enter your email");
				rd.forward(req, res);
			}
			else{
				RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword.jsp");
				req.setAttribute("password", "Your Email id is not valid");
				rd.forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
