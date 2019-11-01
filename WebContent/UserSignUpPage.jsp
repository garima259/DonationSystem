<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
<style type="text/css">
form
{
font-family: fantasy;
font-size: 20px;

text-align: center;
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

	font-size: 70px;
	text-align: center;
	margin-left: 40%;
	margin-right: 40%;
}

body {
	background-image: url("seniorCitizen.png"); /* The image used */
	background-color: #58C2C2; /* Used if the image is unavailable */
	/* height: 550px; /* You must set a specified height */-->
	/*background-position: 170px 50px; /* Center the image */
	background-repeat: no-repeat; /* Do not repeat the image */
	background-size:cover;
	margin-top: 100px;
}
img{

opacity: 0.3;
	filter: alpha(opacity = 50);
	size: 50%;
}
</style>
</head>
<body>

	<form action="./UserSignUp" method="post">
		<h1>Umeed</h1>
		<!--  <img src="seniorcitizen.jpeg">-->
		<b style = "font-size: 30px">First Name</b> &nbsp;<input type="text" name="firstName" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus""><br><br>
		<b style = "font-size: 30px">Last Name</b>  &nbsp;<input type="text" name="lastName" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus""><br> <br>
		<b style = "font-size: 30px">Email</b>  &nbsp; &nbsp; &nbsp;<input type="text" name="emailId" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus"" value=""><br> <br>
		<b style = "font-size: 30px">Address</b> &nbsp; &nbsp;<input type="text" name="address" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus""><br> <br>
	    <b style = "font-size: 30px"> User Name</b>  &nbsp;<input type="text" name="userId" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus""><br> <br>
		<b style = "font-size: 30px">Password</b>  &nbsp; &nbsp;<input type="password" name="password" value="" placeholder="User Name" style = "font-family :  fantasy; font-size: 20px;" autofocus="autofocus""><br> <br>
		<!--Confirm Password  &nbsp;<input type="password" name="password2" value=""><br> <br>-->
		<button input type="submit" name="submit" value="submit"style="font-family: fantasy;font-size: 30px; margin-left: 5%" ><b>Submit</b></button>
		
	</form>
	
</body>
</html>