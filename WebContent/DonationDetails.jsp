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
	margin-top: 30px;
	font-size: 30px;
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
select {
	align-content: center;
	margin-left: 40%;
	margin-right: 39%;
	width: 290px;
	height: 30px;
	position: relative;
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
	top: 570px;
	font-family: fantasy;
	color: #E3F5F5;
	background-color: black;
	font-size: 20px;
	width: 10%;
}
</style>
</head>
<body>
<h1><%=
			session.getAttribute("ngoName")
		 
		%></h1>
<form action="./DonationMethod" method="post">
		
		<h1>Select method of Donation</h1> <br><br>
		<select name="donationMethod">
		
		<option>Money</option>
		<option>Food</option>
		<option>Volunteering</option>
		<option>Clothes</option>

		</select><br>
		<br>
		<h1>Enter Units</h1> <br><br>
		<input type="number" name="donationValue" value=""><br> <br>
		<button input type="submit" name="NgoName" value="donationMethod"
		style="margin-left: 350px;">Submit</button>
		</form>
</body>
</html>