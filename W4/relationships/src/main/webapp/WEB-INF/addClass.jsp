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
<title>Add a Class</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
      <div class="d-flex flex-column">
        <h1>New Class</h1>
        <a href="/">Dashboard</a>
      </div>
        <div class="w-50">
            <form:form action="/dojo/new/class" method="POST" modelAttribute="class">
            <form:label path="name" class="form-label">Name:</form:label>
            <form:input type="text" path="name" class="form-control"/>
            <button type="submit" class="w-25 mt-2 btn btn-dark text-light">Add</button>
            </form:form>
        </div>
	</div>
</body>
</html>