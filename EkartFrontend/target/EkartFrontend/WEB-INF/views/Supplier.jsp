<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>supplier</title>
</head>
<body>
<form action="addSupplier" method="post">
<table align="center" class="table-bordered">
<tr>
<td colspan="4">Supplier Details</td>
</tr>
<tr>
<td>Supplier Name</td>
<td> <input type="text" name="suppliername" required/></td>
</tr>
<tr>
<td>Address</td>
<td> <input type="text" name="address" required/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Enter Supplier" required/></td></tr>
</table>
</form>
<table align="center" class="table-bordered">
<tr><td colspan="3"><center>Supplier Details </center></td></tr>
<tr><td>Supplier ID</td>
<td>Supplier Name</td>
<td>Address</td>
<td>Operation</td>
</tr>
<c:forEach items="${supplierList}" var="supplier">
<tr>
<td>${supplier.supplierid}</td>
<td>${supplier.suppliername}</td>
<td>${supplier.address}</td>
<td>
<a href="<c:url value='/deleteSupplier/${supplier.supplierid}'/>"><button type="button" class="btn btn-danger">Delete</button></a>
<a href="<c:url value='/editSupplier/${supplier.supplierid}'/>"><button type="button" class="btn btn-warning">Edit</button></a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>