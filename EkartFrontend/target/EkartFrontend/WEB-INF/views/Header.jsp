<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page isELIgnored="false" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Shopping</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand/logo -->
					<a class="navbar-brand" href="">Ekart</a>
				

				<!-- Links -->
				
			<c:if test="${!sessionScope.loggedIn}">
				<ul class="nav navbar-nav">
					<li class="nav-item">
					<a class="nav-link" href="home">Home</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" href="register">Register</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" href="aboutus">About Us</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" href="contactus">Contact Us</a>
					</li>
					<!--  <li class="nav-item">
					<a class="nav-link" href="cart">My Cart</a>
					</li>-->
					</ul>
					<ul class="nav navbar-nav navbar-right"><li>
					
					<a class="nav-link" href="<c:url value="/login"/>" ><span class="glyphicon glyphicon-log-in">Login</a>
					</li></ul>
					
					</c:if>					
					<c:if test="${sessionScope.loggedIn}">
					<c:if  test="${sessionScope.role=='ROLE_USER'}">
					<ul class="nav navbar-nav">
					<li  class="nav-item"><a href="home">Home</a>
					<li><a href="<c:url value="/user/productDisplay"/>">Product Display</a></li></ul>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/user/cart"/>">My Cart</a></li>
					</ul>
					<ul>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/user/myorder"/>">MyOrder</a></li></ul>
					<c:if test="${sessionScope.loggedIn}">
					<ul class="nav navbar-nav navbar-right">
					<li class="nav-item"><a class="nav-link">Hi ${sessionScope.username}</a></li>
					<li>
					<a class="nav-link" href="<c:url value="/perform_logout"/>">Logout</a>
					</li></ul>
					</c:if>
					
				</c:if>
				</c:if>
                <c:if test="${sessionScope.loggedIn}">
				<c:if  test="${sessionScope.role=='ROLE_ADMIN'}">
				<ul class="nav navbar-nav">
					<li><a href="home">Home</a>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/category"/>">Category</a></li>
					</ul>
					<ul>
					<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/product"/>">Product</a></li></ul>
					<li class="nav-item"><a class="nav-link">Hi ${sessionScope.username}</a></li>
					<li><a class="nav-item" href="<c:url value="/perform_logout"/>">Logout</a>
					</li></ul>
				</c:if>	
				</c:if>				
			</nav>
</body>
</html>