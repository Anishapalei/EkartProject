<%@include file="Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
orderdet
Your OrderID:${orderdet.orderId}<br/>
Ordered on :${orderdet.orderDate}<br/>
Payment mode: ${orderdet.pmode}<br/>
<c:url value='/home' var="url" />
<form action="${url}" method="get">

<button type="submit">Continue
</button>

</form>

<!--   <a  href="<c:url value='/home' />" class="btn btn-info" >continue shopping</a>-->

			

</body>
</html>
