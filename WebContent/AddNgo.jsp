<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</style>
</head>
<body style="opacity: 0.7; filter: alpha(opacity = 50);" >
<form action="./AddOrRemoveNgo" method="post">
		<h1>Umeed</h1>
		<h3>Enter Ngo Name</h3>
		<input type="text" name="addNgoName" value=""><br> <br>
		<h3>Choose Ngo category</h3>
		<select name="categoryList">
		<%
			List<String> categoryList =  (List<String>)session.getAttribute("categoryList");
		//categoryList.add(0, "None");
		 //categoryList.set(0, "None");
		// categoryList.set(categoryList.size()-1, "ChildCare");
			for (String category : categoryList) {
		%>
		<option><%=category%></option>
		<%
			}
		%>
			
		</select><br>
		<button input type="submit" name="addNgo" value="submit"
			style="margin-left: 350px;">Add Ngo</button><br><br>
			</form>
			
</body>
</html>