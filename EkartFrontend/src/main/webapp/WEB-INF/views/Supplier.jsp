<%@include file="Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>
<c:url value="/admin/addSupplier" var="url" />
<form:form action="${url}" modelAttribute="supplier" method="post">
	<table align="center" class="table table-bordered">
		<tr>
               <td>SupplierId:</td>
               <td><form:input type="hidden" path = "supplierId" /></td>
            </tr>
		<tr>
			<td>Supplier Name</td>
			<td><form:input path="supplierName" /></td>
		</tr>
		<tr>
			<td>Supplier Addr</td>
			<td><form:input path="supplierAddr" /></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="AddSupplier" /></td>
		</tr>
	</table>
</form:form>

<table  class="table table-bordered">
<tr>
		<td>Supplier Id</td>
		<td>Supplier Name</td>
		<td>Supplier Addr</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${listSuppliers}" var="supplier">
	<tr>
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierAddr}</td>
		<td>
			<a class= "btn btn-success" href="<c:url value="/admin/editSupplier/${supplier.supplierId}"/>">Edit</a>
			<a  class="btn btn-danger" href="<c:url value="/admin/deleteSupplier/${supplier.supplierId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
</div>

</body>
</html>