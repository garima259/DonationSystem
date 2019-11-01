<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link href="StyleSheet.css" rel="stylesheet" type="text/css">

</head>
<body background="happychildrenorphans.jpg"
	style="opacity: 0.7; filter: alpha(opacity = 50); size: 50%;">
	<form action="./UserLogin" method="post">

		<h1>Umeed</h1>
		<h3>Enter User Name</h3>
		<input type="text" name="userName" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus"" ><br> <br>
		<h3 style="margin-top: 50px;">Enter Password</h3>
		<input type="password" name="password" value="" placeholder="Password" style = "font-family :  fantasy;font-size: 20px"><br> <br>
		<button input type="submit" name="Login" value="login"
			style="margin-left: 350px;">Login</button><br><br>
		<a href="./AdminLogin.jsp" style = " margin-left: 30%;"><b>Admin?</b></a>
		<a href="./UserSignUpPage.jsp" style = "margin-left:27%; margin-top: 30px; "><b>Don't have an account? Sign up now</b> </a>
		</form>
</body>
</html>