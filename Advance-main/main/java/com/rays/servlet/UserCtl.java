package com.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.jar.Attributes.Name;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/UserCtl")
public class UserCtl extends HttpServlet {
	
    public UserCtl() {
        super();
    }  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Userbean bean = new Userbean();
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String Date=request.getParameter("Date");
		String address=request.getParameter("address");
	 
		bean.setName(name);
		bean.setNumber(number);
		bean.setEmail(email);
		bean.setpassword(password);
		bean.setGender(gender);
		bean.setDate(Date);
		bean.setAddress(address);
		
		UserModel um = new UserModel();
	
		try {if(name.equals("")) {
			System.out.println("null.....................");
			RequestDispatcher rd= request.getRequestDispatcher("UserRegistration.jsp");
			  
			  rd.forward(request, response);
		}
		else if(bean!=null){
			System.out.println("first");	
			um.add(bean);
			RequestDispatcher rd= request.getRequestDispatcher("UserRegistration.jsp");
			  
			  rd.forward(request, response);
			}else {
				System.out.println("second");
				RequestDispatcher rd= request.getRequestDispatcher("UserRegistration.jsp");
				  
				  rd.forward(request, response);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
