<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Your Order</h3>

<table class="table bordered" >
  <tr bgcolor="yellow">
   
    <td>SL# </td>
    <td>ProductName</td>
    <td> Quantity</td>
    <td>Price </td>
    <td>TotalPrice</td>
    

  </tr>
  
  <c:forEach items="${cartItems}" var="cart">
  <form action="<c:url value="/user/updateCartItems/${cart.cartId}"/>" method="get">
  <tr>
  	<td>${cart.productName}</td>
    <td>${cart.quantity}"</td>
    <td> ${cart.price}</td>
    <td>${cart.quantity}*${cart.price}/-</td>
    
    </tr>
    </form>
  </c:forEach>
  <tr bgcolor="cyan">
  	<td colspan="4">GrandTotal</td>
  	<td>Rs.${grandTotal}/-</td>
  	</tr>
  	<tr bgcolor="green">
  	<td colspan="3"><a href="<c:url value="/cart"/>">Edit Cart</a></td>
  	<td colspan="2"><a href="<c:url value="/"/>">Checkout></a></td>
  	</tr>
  	
</table>
<div class="container"></div>
<form action="paymentprocess" method="post">
<table class="table bordered">
<tr>
	<td>Payment Detail</td>
	</tr>
	<tr>
	<td>Payment Type</td>
	<td><input type="radio"  name="pmode" value="COD">Cash On Delivery
	<td><input type="radio"  name="pmode" value="CC">Credit Card
	</td>
	</tr>
	<tr>
	<td>Credit Card</td>
	
	<td><input type="text"  name="creditcard"/>
	</td>
	</tr>
	<tr>
	<td>CVV<input type="text"  name="CVV"/></td>
	
	<td>Valid Upto<input type="text"  name="valid"/></td>
	</tr>
	
	<tr bgcolor="yellow">
	<td colspan="2" ><input type="submit"  value="pay"/></td>
	
	</tr>
	
</form>
</table>