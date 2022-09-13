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
<title>Add Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container d-flex flex-column">
		<div class="d-flex justify-content-between">
			<h1>New Ninja</h1>
			<a href="/">Home</a>
		</div>
		<div class="form d-flex flex-column mt-2">
			<form:form action="/dojo/new/ninja" method="POST" modelAttribute="ninja" class="w-50">
			<div>
                <form:label path="dojo" class="form-label">Dojo:</form:label>
                <form:select path="dojo">
                    <c:forEach var="dojo" items="${dojos}">
                        <form:option path="dojo" value="${dojo.id}">${dojo.name}</form:option>
                    </c:forEach>
                <form:errors path="dojo" class="text-danger"/>
                </form:select>
			</div>
            <div>
				<form:label path="firstName">First Name:</form:label>
                <form:errors path="firstName" class="text-danger"/>
				<form:input type="text" path="firstName" class="form-control"/>
			</div>
            <div>
				<form:label path="lastName">Last Name:</form:label>
                <form:errors path="lastName" class="text-danger"/>
				<form:input type="text" path="lastName" class="form-control"/>
			</div>
            <div>
				<form:label path="age">Age:</form:label>
                <form:errors path="age" class="text-danger"/>
				<form:input type="text" path="age" class="form-control"/>
			</div>
			<button class="btn btn-dark text-light w-25 mt-2" type="submit">Create</button>
			</form:form>
		</div>
    </div>
</body>
</html>