<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="text-success">Fruit Store</h1>
		<table class=" table table-dark">
			<thead>
				<tr>
					<td>Name</td>
					<td>Name</td>					
				</tr>
			</thead>
			<tbody>
			<c:forEach var="fruit" items="${fruits}">
				<tr>
					<td><c:out value="${fruit.name}"></c:out></td>
					<td>$<c:out value="${fruit.price}"></c:out></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>