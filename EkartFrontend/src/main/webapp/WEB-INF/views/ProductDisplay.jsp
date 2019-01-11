<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3 align="center">Product Display</h3>

<div class="row text-center text-1g-left">

<c:forEach items="${productlist}" var="product">
	<div class="col-1g-3 col-md-4 col-6">
		<a href="<c:url value="/cart/totalProductDisplay/${product.productId}"/>" >
		<img src="<c:url value="/resources/images/${product.productId}.jpg" />" width="100" height="100"/>
		
		<p>${product.productName}</p>
		<p>Price: ${product.price}/-</p> 
		 <p>Quantity:<c:if test=" ${product.quantity>0}">
		${product.quantity}
		</c:if>
		<c:if test="${product.quantity<=0}">
		<font color="red">Out of stock</font>
		</c:if>
		</p>
		</a>
	</div>
	</c:forEach>
	</div>