<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a {
	font-size: 30px;
	color: white;
	margin-left: 30%;
	font-family: fantasy;
	
	
}

img {
	opacity: 0.5;
	filter: alpha(opacity = 50);
	size: 50%;
}

body {
	background-image: url("happykids.png"); /* The image used */
	/*background-color: #58C2C2; /* Used if the image is unavailable */
	background-color: black;
	height: 400px; /* You must set a specified height */
	background-position: 170px 50px; /* Center the image */
	background-repeat: no-repeat; /* Do not repeat the image */
	background-size: contain;
	margin-top: 100px;
}
</style>
</head>
<body>
	<a href="AddNgo.jsp">Click here to add a NGO</a>
	<br>
	<br>
	<a href="RemoveNgo.jsp">Click here to remove a NGO</a>
	<br>
	<br>
	<a href="./GetNgoDonation">Click here to see Value of all the NGOs</a>
	<br>
	<br>
	<a href="./GetUserDonation">Click here to see Donations made by all the users</a>
	<br>
	<br>
</body>
</html>