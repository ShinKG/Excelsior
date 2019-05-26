<?php

	$url = 'localhost';
	$db = 'webtechphp';
	$user = 'root';
	$password = '';

	$conn = new mysqli($url, $user, $password, $db);

	if ($conn->connect_error) die($conn->connect_error);

?>