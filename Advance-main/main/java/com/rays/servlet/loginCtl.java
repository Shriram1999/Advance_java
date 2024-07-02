package com.rays.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet(urlPatterns = "/loginCtll")
public class loginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		 * Userbean bean = new Userbean(); bean.setEmail(request.getParameter("email"));
		 * bean.setpassword(request.getParameter("password")); UserModel um = new
		 * UserModel(); PrintWriter out=response.getWriter(); Userbean b=null; //try {
		 * //um.add(bean); //} catch (Exception e) { // TODO Auto-generated catch block
		 * //e.printStackTrace(); //} try { b=new Userbean(); b=um.auth(bean.getEmail(),
		 * bean.getpassword()); if(b!=null) { System.out.print(b);
		 * out.print("sucessful login"); } else { out.print("unsucessful login");
		 * 
		 * }
		 * 
		 * 
		 * } catch(Exception e) { out.print("please Login"); }
		 */
        HttpSession session=req.getSession(true);
		Userbean bean = new Userbean();
		UserModel um = new UserModel();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String emailreq = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String passwordreg ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{5,20}$";

	 	if(email.equals("") && password.equals("")){
			RequestDispatcher rd=req.getRequestDispatcher("loginview.jsp");
			req.setAttribute("one", "email and pwd is required");
			rd.forward(req, res);
		}
		else if(email.equals("")){
			RequestDispatcher rd=req.getRequestDispatcher("loginview.jsp");
			req.setAttribute("email", "email is required");
			rd.forward(req, res);	
		}
		else if(password.equals("")){
			RequestDispatcher rd=req.getRequestDispatcher("loginview.jsp");
			req.setAttribute("pwd", "password is required");
			rd.forward(req, res);	
		}else if(!email.matches(emailreq) && !password.matches(passwordreg)){
			RequestDispatcher rd=req.getRequestDispatcher("loginview.jsp");
			req.setAttribute("email", "email and password is required");
			rd.forward(req, res);
		}else if(!email.matches(emailreq)){
			RequestDispatcher rd=req.getRequestDispatcher("loginview.jsp");
			req.setAttribute("email", "email is required");
			rd.forward(req, res);
		}else if(!password.matches(passwordreg)){
			RequestDispatcher rd=req.getRequestDispatcher("loginview.jsp");
			req.setAttribute("email", "password is required");
			rd.forward(req, res);
		}
		else {
			
		}

		try {
			bean = um.auth(email, password);
			if (bean !=null) {
				
				session.setAttribute("User",bean);
				
				RequestDispatcher rd = req.getRequestDispatcher("WelcomeCtll");
				System.out.println("first");
				rd.forward(req, res);
			} else {

				
				RequestDispatcher rd = req.getRequestDispatcher("loginview.jsp");
				System.out.println("second");
				req.setAttribute("Error", "Invalid Username & password");
				rd.forward(req, res);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
