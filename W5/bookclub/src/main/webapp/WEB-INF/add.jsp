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
<title>Add Book</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <div class="d-flex justify-content-between">
            <h1>Add a Book to the Shelf!</h1>
            <a href="/dashboard">Back to the Bookshelf</a>
        </div>
        <div class="d-flex flex-column w-50">
            <form:form action="/book/add" method="POST" modelAttribute="book">
                <form:input type="hidden" path="user" value="${userId}"/>
                <div>
                    <form:label path="title" class="form-label">Title:</form:label>
                    <form:errors path="title" class="text-danger"/>
                    <form:input type="text" path="title" class="form-control"/>
                </div>
                <div>
                    <form:label path="author" class="form-label">Author:</form:label>
                    <form:errors path="author" class="text-danger"/>
                    <form:input type="text" path="author" class="form-control"/>
                </div>
                <div>
                    <form:label path="thoughts" class="form-label">My Thoughts:</form:label>
                    <form:errors path="thoughts" class="text-danger"/>
                    <form:input type="text" path="thoughts" class="form-control"/>
                </div>
                <button type="submit" class="btn btn-dark text-light mt-2">Add Book</button>
            </form:form>
        </div>
	</div>
</body>
</html>