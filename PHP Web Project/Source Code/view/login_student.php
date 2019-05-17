<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>login_student.php</title>
</head>

<body>

<h1>LOGIN_STUDENT.PHP PAGE</h1>
<hr>

<form action="../controller/control_login.php" method="POST">
    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>
    <input name="isStudent" value="true" hidden>
    <input type="submit" value="Login">
</form>

<br>
<a href="index.php">Go Back</a>

</body>

</html>

