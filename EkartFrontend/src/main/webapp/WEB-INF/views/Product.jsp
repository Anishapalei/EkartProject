
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body >
<c:url value="/admin/InsertProduct" var="url" />
<form:form action="${url}" modelAttribute="product" method="post" enctype="multipart/form-data">
	<table align="center" class="table table-bordered">
	<tr>
               <td>productId:</td>
               <td><form:input type="hidden" path = "productId" /></td>
            </tr>
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName" /></td>
		</tr>
		
		<tr>
			<td>Price</td>
			<td><form:input path="price" /></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><form:input path="quantity" /></td>
		</tr>
		<tr>
			<td>Category</td>
			<td><form:select path="categoryId">
					<form:option value="0" label="--Select List--" />
					<form:options items="${categoryList}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td>Supplier</td>
			<td><form:input path="supplierId" /></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="productDesc" /></td>
		</tr>
		<tr>
			<td>Product Image</td>
			<td><form:input type="file" path="pimage" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Insert" /></td>
		</tr>
	</table>
</form:form>

<table align="center" class="table table-bordered">
<tr>
	<td> Product ID </td>
	<td> Product Name </td>
	<td> Category </td>
	<td> Price </td>
	<td> Supplier </td>
	<td> Operation</td>
</tr>
<c:forEach items="${productlist}" var="product">
<tr>
	<td>${product.productId}</td>
	<td>${product.productName}</td>
	<td>${product.categoryId}</td>
	<td>${product.price}</td>
	<td>${product.supplierId}</td>
	<td>
		
		<a class="btn btn-success" href="<c:url value="/admin/editProduct/${product.productId}"/>">Edit</a>
		<a class="btn btn-danger" href="<c:url value="/admin/deleteProduct/${product.productId}"/>">Delete</a>
	</td>
</tr>
</c:forEach>
</table>

</div>

</body>
</html>