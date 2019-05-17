<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Registration.php</title>
</head>

<body>

<h1>REGISTRATION_STUDENT.PHP PAGE</h1>
<hr>

<h2>Student Registration</h2>

<form action="../controller/control_data.php" method="POST">
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
    City:
    <input type="text" name="city" placeholder="City"><br>
    Province:
    <input type="text" name="province" placeholder="Province"><br>
    <input name="isStudent" value="true" hidden>
    <input name="isRegistration" value="true" hidden>
    <input type="submit" name="submit" value="Register">
</form>

<br>

<a href="index.php">Go Back</a>

</body>

</html>