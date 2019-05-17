<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>home.jsp</title>
</head>

<body>

<?php
header("Cache-Control", "no-cache, no-store, must-revalidate");
header("Expires", "0");

if ($_SESSION["Username"] == null) {
header("Location: index.php");
die();
}
?>

<h1>HOME.PHP PAGE</h1>
<hr>

<h2>Welcome to the Home Page!</h2>

<form action="../controller/control_logout.php" method="POST">
    <input type="submit" value="Logout">
</form>

</body>

</html>