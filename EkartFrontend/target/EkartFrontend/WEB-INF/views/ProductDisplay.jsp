<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3 align="center">Product Display</h3>

<div class="row text-center text-1g-left">

<c:forEach items="${productlist}" var="product">
	<div class="col-1g-3 col-md-4 col-6">
		<a href="<c:url value="/user/totalProductDisplay/${product.productId}"/>" >
		<img src="<c:url value="/resources/images/${product.productId}.jpg" />" width="100" height="100"/>
		<p>Price: ${product.price}/-</p> 
		<p>Stock: ${product.stock}</p>
		</a>
	</div>
	</c:forEach>
	</div>