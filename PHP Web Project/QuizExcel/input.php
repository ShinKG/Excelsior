<?php

echo <<<_END

<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/style1.css">
</head>
<body>
<div class="input">
<form action="getname.php" method="POST">
    <h5>input name: <input type="text" id="fname" name="fname"></h5>
    <h5>input number of questions: <input type="text" id="numque" name="numque"></h5>
    <input type="radio" name="Topic" value="HTML">Hypertext Markup Language<br>
    <input type="radio" name="Topic" value="CSS">Cascading Stylesheet<br>
    <input type="radio" name="Topic" value="JS">Javascript<br>
    <p><input type="submit" value="Start"></p>
</form>
</div>

</body>
_END

?>
