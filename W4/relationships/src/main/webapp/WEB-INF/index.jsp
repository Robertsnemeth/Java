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
<title>Dojo Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container d-flex flex-column">
			<h1>Dojos</h1>
			<a href="/dojo/new/ninja">Add Ninja</a>
			<a href="/dojo/new/class">Add Class</a>
			<a href="/all/class">View all classes</a>
		<div class="w-50">
			<table class="table table-dark">
				<thead>
					<tr>
						<td>Dojo</td>
						<td>Actions</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${dojos}">
						<tr>
							<td><a href="/dojo/ninjas/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
							<td>
								<form action="/dojo/delete/${dojo.id}" method="POST">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" value="Delete" class="btn btn-danager text-danger">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="form d-flex flex-column mt-2">
			<form:form action="/" method="POST" modelAttribute="dojo" class="w-50">
			<div>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input type="text" path="name" class="form-control"/>
			</div>
			<button class="btn btn-dark text-light w-25 mt-2" type="submit">Create</button>
			</form:form>
		</div>
    </div>
</body>
</html>