<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserHome</title>
</head>
<body backgrnd="<c:url value="/resources/images/backgrnd.jpg"/>">
<h2>Welcome  ${sessionScope.username}</h2>
<div class="row text-center text-1g-left">

<c:forEach items="${productlist}" var="product">
	<div class="col-1g-3 col-md-4 col-6">
		<a href="<c:url value="/cart/totalProductDisplay/${product.productId}"/>" >
		<img src="<c:url value="/resources/images/${product.productId}.jpg" />" width="100" height="100"/>
		<p>Price: ${product.price}/-</p> 
		<p>Quantity: ${product.quantity}/-</p> 
		 </a>
		
	</div>
	</c:forEach>
	</div>
</body>
</html>
