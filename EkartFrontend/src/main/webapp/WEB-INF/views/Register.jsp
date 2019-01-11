<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register form</title>
</head>
<body backgrnd="<c:url value="/resources/images/backgrnd.jpg"/>">

	<form:form action="registerUser" modelAttribute="user" method="post" id="form">
<table align="center">
	<tr>
		<td colspan="2"><center>Register User</center></td>
	</tr>
	<tr>
		<td>UserName</td>
		<td><form:input path="username"   required="true"/></td>
	</tr>
	<tr >
		<td>Password</td>
		<td><form:input path="password"  type="password"  required="true"/></td>
	</tr>
	
	<tr>
		<td>Email Id</td>
		<td><form:input path="emailId" type="email"  required="true"/></td>
	</tr>
	<tr >
		<td>Phone number</td>
		<td><form:input type="text" pattern="[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]" path="mobileNo" required="true"/></td>
	</tr>
	<tr >
		<td>Address</td>
		<td><form:input path="address"  required="true"/></td>
	</tr>
	<tr>
		<td colspan="2"><center>
				<input type="submit" value="Register"/>
				<center>
		</td>
	</tr>
	
</table>
</form:form>
</body>
</html>