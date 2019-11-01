<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css">
h3 {
	background-color: #DBE5E5;
	background-size: center center;
	padding-top: 5px;
	padding-left: 5px;
	padding-right: 5px;
	padding-bottom: 5px;
	align-content: center;
	font-family: fantasy;
	margin-left: 40%;
	margin-right: 39%;
	position: relative;
}

h1 {
	color: #0F54CB;
	background-color: #DBE5E5;
	background-size: center center;
	padding-top: 3px;
	padding-left: 3px;
	padding-right: 3px;
	padding-bottom: 3px;
	align-content: center;
	font-family: fantasy;
	margin-top: 100px;
	font-size: 70px;
	text-align: center;
	margin-left: 40%;
	margin-right: 40%;
}

input {
	align-content: center;
	margin-left: 40%;
	margin-right: 39%;
	width: 290px;
	height: 30px;
	position: relative;
}

img {
	opacity: 0.5;
	filter: alpha(opacity = 50);
	size: 50%;
}

body {
	background-image: url("happykids.png"); /* The image used */
	/*background-color: #58C2C2; /* Used if the image is unavailable */
	background-color:black;
	height: 400px; /* You must set a specified height */
	background-position: 170px 50px; /* Center the image */
	background-repeat: no-repeat; /* Do not repeat the image */
	background-size: contain;
	margin-top: 100px;
}

button {
	position: absolute;
	left: 260px;
	top: 550px;
	font-family: fantasy;
	color: #E3F5F5;
	background-color: black;
	font-size: 20px;
	width: 10%;
}
a {
	font-size: 30px;
	color: white;
	
	
	
	font-family: fantasy;
}
</style>
</head>
<body background="happychildrenorphans.jpg"
	style="opacity: 0.7; filter: alpha(opacity = 50); size: 50%;">
	<form action="./AdminLogin" method="post">

		<h1>Umeed</h1>
		<h3>Enter Admin Id</h3>
		<input type="text" name="adminId" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus""><br> <br>
		<h3 style="margin-top: 50px;">Enter Password</h3>
		<input type="password" name="password" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus""><br> <br>
		<button input type="submit" name="Login" value="login"
			style="margin-left: 350px;">Login</button><br><br>
		
		</form>
</body>
</html>