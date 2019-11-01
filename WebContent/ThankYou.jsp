<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
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
	margin-top: 150px;
	font-size: 50px;
	text-align: center;
	margin-left: 20%;
	margin-right: 20%;
}
input {
	align-content: center;
	margin-left: 40%;
	margin-right: 39%;
	width: 290px;
	height: 30px;
	position: relative;
}
select {
	align-content: center;
	margin-left: 40%;
	margin-right: 39%;
	width: 290px;
	height: 30px;
	position: relative;
}
body {
	background-image: url("seniorCitizen.png"); /* The image used */
	/*background-color: #58C2C2; /* Used if the image is unavailable */
	background-color:black;
	height: 400px; /* You must set a specified height */
	background-position: 160px 50px; /* Center the image */
	background-repeat: no-repeat; /* Do not repeat the image */
	background-size: contain;
	margin-top: 100px;
}
button {
	position: absolute;
	left: 260px;
	top: 500px;
	font-family: fantasy;
	color: #E3F5F5;
	background-color: black;
	font-size: 20px;
	width: 10%;
}
</style>
</head>
<body>
<h1><%="Thank You "+
			session.getAttribute("userName") +" for donating in "+session.getAttribute("ngoName")
		 +"! :)"
		%></h1>
</body>
</html>