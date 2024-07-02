package com.raystech.Marksheet;

import java.util.Locale;
import java.util.ResourceBundle;

public class testResourceBundle {
	public static void main(String[] args) {
		
	
	ResourceBundle rb = ResourceBundle.getBundle("com.raystech.rb.app");
	System.out.println("Driver : "+ rb.getString("driver"));
	System.out.println("url : "+ rb.getString("url"));
	System.out.println("user : "+ rb.getString("user"));
	System.out.println("Password : "+ rb.getString("password"));
	
	rb = ResourceBundle.getBundle("com.raystech.rb.lag" , new Locale("hi"));
	System.out.println(rb.getString("greeting"));
	
	rb = ResourceBundle.getBundle("com.raystech.rb.lag" , new Locale("sp"));
	System.out.println(rb.getString("greeting"));
	}
}
