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
<title>Login and Registration</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<h1>Welcome!</h1>
    <p>Join the growing community</p>
    <div class="row">
        <div class="col d-flex flex-column">
            <h1>Register</h1>
            <div>
                <form:form action="/register" method="POST" modelAttribute="user">
                    <div>
                        <form:label path="userName" class="form-label">User Name:</form:label>
                        <form:errors path="userName" class="text-danger"/>
                        <form:input type="text" path="userName" class="form-control"/>
                    </div>
                    <div>
                        <form:label path="email" class="form-label">Email:</form:label>
                        <form:errors path="email" class="text-danger"/>
                        <form:input type="text" path="email" class="form-control"/>
                    </div>
                    <div>
                        <form:label path="password" class="form-label">Password:</form:label>
                        <form:errors path="password" class="text-danger"/>
                        <form:input type="password" path="password" class="form-control"/>
                    </div>
                    <div>
                        <form:label path="confirm" class="form-label">Password(Confirm):</form:label>
                        <form:errors path="confirm" class="text-danger"/>
                        <form:input type="password" path="confirm" class="form-control"/>
                    </div>
                    <button class="btn btn-dark text-light mt-2" type="submit">Register</button>
                </form:form>
            </div>
        </div>
        <div class="col d-flex flex-column">
            <h1>Login</h1>
            <div>
                <form:form action="/login" method="POST" modelAttribute="login">
                    <div>
                        <form:label path="email" class="form-label">Email:</form:label>
                        <form:errors path="email" class="text-danger"/>
                        <form:input type="text" path="email" class="form-control"/>
                    </div>
                    <div>
                        <form:label path="password" class="form-label">Password:</form:label>
                        <form:errors path="password" class="text-danger"/>
                        <form:input type="password" path="password" class="form-control"/>
                    </div>
                    <button class="btn btn-dark text-light mt-2" type="submit">Login</button>
                </form:form>
            </div>
        </div>
    </div>
	</div>
</body>
</html>