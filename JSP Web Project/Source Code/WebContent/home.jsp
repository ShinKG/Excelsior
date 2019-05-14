<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>home.jsp</title>
</head>

<body>

	<%
	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Expires", "0");
	
		if (session.getAttribute("Username") == null) {
			response.sendRedirect("index.jsp");
		}
	
	%>

	<h1>HOME.JSP PAGE</h1>
	<hr>
	
	<h2>Welcome to the Home Page!</h2>
	
	<form action="Logout" method="POST">
		<input type="submit" value="Logout">
	</form>

</body>

</html>