package com.authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginStudent")
public class LoginStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
		
		if (Username.equalsIgnoreCase("StudentUsername") && Password.equals("studentpassword")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("Username", Username);
			response.sendRedirect("home.jsp");
			
		} else {
			
			response.sendRedirect("index.jsp");
			
		}
	}

}
