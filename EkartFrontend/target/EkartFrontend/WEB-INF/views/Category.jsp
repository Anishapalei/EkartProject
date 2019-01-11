<%@include file="Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form action="addCategory" modelAttribute="category" method="post" >
	<table align="center" class="table table-bordered">
		<tr>
			<td>Category Name</td>
			<td><form:input path="categoryName" /></td>
		</tr>
		<tr>
			<td>Category Desc</td>
			<td><form:input path="categoryDesc" /></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="AddCategory" /></td>
		</tr>
	</table>
</form:form>

<table  class="table table-bordered">
<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a class= "btn btn-success" href="<c:url value="/admin/editCategory/${category.categoryId}"/>">Edit</a>
			<a  class="btn btn-danger" href="<c:url value="/admin/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
</div>

</body>
</html>