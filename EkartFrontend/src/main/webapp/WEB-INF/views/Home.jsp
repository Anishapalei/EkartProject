<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="Header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="<c:url value="/resources/images/background1.jpg"/>">

<div class="container">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
       <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="<c:url value='/resources/images/samsung.jpg' ></c:url>" style="width:80%;">
      </div>

      <div class="item">
        <img src="<c:url value='/resources/images/Google.jpg' ></c:url>" style="width:80%;">
      </div>
    
      <div class="item">
        <img src="<c:url value='/resources/images/watch.jpg' ></c:url>" style="width:80%;">
      </div>
       <div class="item">
        <img src="<c:url value='/resources/images/headphone.jpg' ></c:url>" style="width:80%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div class="container">
  <h2>Mobiles</h2>
   <div class="row">
  <c:forEach items="${productlist}" var="product">
 <div class="col-md-4">
  <img src="<c:url value='/resources/images/${product.productId}.jpg' ></c:url>" width="150 px" height="100 px"/><br />
  <p>Product Name: ${product.productName}</p><br />
  <p>Price: ${product.price}</p><br />
  <p>Quantity: ${product.quantity}</p>
  <br/>
  <a href="<c:url value="/cart/totalProductDisplay/${product.productId}" />" ><button type="button" class="btn btn-primary">View Product</button></a>
 </div>
 
  </c:forEach>
  </div>
  </div>
</body>
</html>
    