package com.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data_access_object.RegistrationDAO;

@WebServlet("/RegisterTutor")
public class RegisterTutor extends HttpServlet {

	TutorRegInfo registrationInfo = new TutorRegInfo();
	RegistrationDAO registrationDAO = new RegistrationDAO();
	
	String Username;
	String Password;
	String Email;
	String FirstName;
	String LastName;
	String School;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Username = request.getParameter("username");
		Password = request.getParameter("password");
		Email = request.getParameter("email");
		FirstName = request.getParameter("firstname");
		LastName = request.getParameter("lastname");
		School = request.getParameter("school");
		
		registrationInfo.setUsername(Username);
		registrationInfo.setPassword(Password);
		registrationInfo.setEmail(Email);
		registrationInfo.setFirstName(FirstName);
		registrationInfo.setLastName(LastName);
		registrationInfo.setSchool(School);
		
		registrationDAO.connectToDB();
		registrationDAO.registerTutorInfo(registrationInfo);
		
		response.sendRedirect("registration_tutor.jsp");
		
	}

}
