package com.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data_access_object.TutorAuthDAO;

@WebServlet("/LoginTutor")
public class LoginTutor extends HttpServlet {
	
	TutorAuthDAO authDAO = new TutorAuthDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		authDAO.connectToDB();
		
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
		
		if (authDAO.checkCredentials(Username, Password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("Username", Username);
			response.sendRedirect("home.jsp");
			
		} else {
			
			response.sendRedirect("index.jsp");
			
		}
	}

}
