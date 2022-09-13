<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@page import="java.text.DecimalFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${dojo.name} Ninjas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container d-flex flex-column">
		<div class="d-flex justify-content-between">
			<h1>${dojo.name} Ninjas</h1>
			<a href="/">Home</a>
		</div>
		<div class="w-50">
			<table class="table table-dark">
				<thead>
					<tr>
						<td>Name</td>
						<td>Age</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${ninjas}">
						<tr>
							<td>
								<a href="/student/${student.id}">
									<c:out value="${student.firstName}"/> 
									<c:out value="${student.lastName}"/>
								</a>
							</td>
							<td><c:out value="${student.age}"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
    </div>
</body>
</html>