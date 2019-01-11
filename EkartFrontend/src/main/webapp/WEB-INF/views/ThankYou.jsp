<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>After payment</title>
</head>
<body>
<h2>Thank You</h2>
<table>
<c:forEach items="${TodaysOrder}" var="ord">
<tr>
<td>Order Id:${ord.orderId}</td>

</tr>
</c:forEach>
</table>

</body>
</html>