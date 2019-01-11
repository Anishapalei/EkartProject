<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>My Order History:</h2>
<table>
<c:forEach items="${listorder}" var="history">
<tr>
<td><a href="<c:url value="/cart/OrderBy/${history.orderId}" />">Order Id: ${history.orderId}</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>