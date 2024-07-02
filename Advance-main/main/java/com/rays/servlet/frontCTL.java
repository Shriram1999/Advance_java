package com.rays.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "frontCTL" , urlPatterns = "*.do")
public class frontCTL implements Filter {

  

	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession();
		if(session.getAttribute("User")==null){
			request.setAttribute("error", "Session is Expired Pls login");
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);	
		}else {
			//pab the req. close the filter chain
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	 
    public frontCTL() {
      
    }

	
	public void destroy() {
	
	}

}
