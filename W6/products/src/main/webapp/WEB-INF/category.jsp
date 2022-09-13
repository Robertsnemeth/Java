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
<title>New Category</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <div class="d-flex justify-content-between border-bottom border-dark">
            <div class="mb-2">
                <h1>New Category</h1>
                <a href="/">Home</a>
            </div>
        </div>
        <div class="container">
            <form:form action="/category/new" method="POST" modelAttribute="category">
                <div>
                    <label path="name" class="form-label">Name:</label>
                    <form:input type="text" path="name" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-dark text-light mt-2">Submit</button>
            </form:form>
        </div>
	</div>
</body>
</html>