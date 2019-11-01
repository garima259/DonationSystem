<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
 <%@page import="org.res.model.entity.donation.DonationDetails"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
body {
	/*background-image: url("happykids.png"); /* The image used */
	/*background-color: #58C2C2; /* Used if the image is unavailable */
	background-color:grey;
	/*height: 400px; /* You must set a specified height */
	/*background-position: 170px 50px; /* Center the image */
	background-repeat: no-repeat; /* Do not repeat the image */
	background-size: cover;
	margin-top: 100px;
}
td,th {

	background-color: #DBE5E5;
	background-size: center center;
	padding-top: 20px;
	padding-left: 20px;
	padding-right: 20px;
	font-family: fantasy;
	font-size: 30px;
	margin-left:3%;
	
}
</style >
</head>

<body style ="background-color: grey;">

	<table style ="margin-left :25%; color :blue ; font-size:30px ; margin-top :50px ">
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Money</td>
			<td>Food</td>
			<td>Clothes</td>
			<td>Volunteer</td>
		</tr>
		<%
		
			List<DonationDetails> donationList = (List<DonationDetails>) session.getAttribute("donationListByUser");
			for (DonationDetails donationDetails : donationList) {
		%>
		<tr>
			<td><%=donationDetails.getFirstName()%></td>
			<td><%=donationDetails.getLastName()%></td>
			<td><%=donationDetails.getMoney()%></td>
			<td><%=donationDetails.getFood()%></td>
			<td><%=donationDetails.getClothes()%></td>
			<td><%=donationDetails.getVolunteer()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>