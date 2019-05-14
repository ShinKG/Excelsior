package com.registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data_access_object.RegistrationDAO;

@WebServlet("/RegisterStudent")
public class RegisterStudent extends HttpServlet {
	
	StudentRegInfo registrationInfo = new StudentRegInfo();
	RegistrationDAO registrationDAO = new RegistrationDAO();
	
	String Username;
	String Password;
	String Email;
	String FirstName;
	String LastName;
	String School;
	String City;
	String Province;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Username = request.getParameter("username");
		Password = request.getParameter("password");
		Email = request.getParameter("email");
		FirstName = request.getParameter("firstname");
		LastName = request.getParameter("lastname");
		School = request.getParameter("school");
		City = request.getParameter("city");
		Province = request.getParameter("province");
		
		registrationInfo.setUsername(Username);
		registrationInfo.setPassword(Password);
		registrationInfo.setEmail(Email);
		registrationInfo.setFirstName(FirstName);
		registrationInfo.setLastName(LastName);
		registrationInfo.setSchool(School);
		registrationInfo.setCity(City);
		registrationInfo.setProvince(Province);
		
		registrationDAO.connectToDB();
		registrationDAO.registerStudentInfo(registrationInfo);
		
		response.sendRedirect("registration_student.jsp");
		
	}

}
