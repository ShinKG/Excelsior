<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>

<body>

	<h1>REGISTRATION_TUTOR.JSP PAGE</h1>
	<hr>
	
	<h2>Tutor Registration</h2>
	
	<form action="RegisterTutor" method="POST">
	Username:
	<input type="text" name="username" placeholder="Username"><br>
	Password:
	<input type="password" name="password" placeholder="Password"><br>
	Email:
	<input type="email" name="email" placeholder="Email"><br>
	First Name:
	<input type="text" name="firstname" placeholder="First Name"><br>
	Last Name:
	<input type="text" name="lastname" placeholder="Last Name"><br>
	School:
	<input type="text" name="school" placeholder="School"><br>
	<input type="submit" name="submit" value="Register">
	</form>
	
	<br>
	
	<a href="index.jsp">Go Back</a>

</body>

</html>