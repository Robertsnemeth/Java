<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@page import="java.text.DecimalFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% DecimalFormat format = new DecimalFormat("$#0.00"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Languages</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column p-5">
        <div class="d-flex justify-content-between">
            <h1>Edit Language</h1>
            <a href="/">Home</a>
        </div>
        <form:form action="/languages/updated/${language.id}" method="POST" class="form d-flex flex-column w-50" modelAttribute="languages">
        <div>
                <form:label path="name" class="form-label">Language:</form:label>
                <form:errors path="name" class="text-danger"/>
                <form:input path="name" type="text" class="form-control" value="${language.name}"/>
            </div>
            <div>
                <form:label path="creator" class="form-label">Creator:</form:label>
                <form:errors path="creator" class="text-danger"/>
                <form:input path="creator" type="text" class="form-control" value="${language.creator}"/>
            </div>
            <div>
                <form:label path="version" class="form-label">Version:</form:label>
                <form:errors path="version" class="text-danger"/>
                <form:input path="version" type="text" class="form-control" value="${language.version}"/>
            </div>
            <button class="btn btn-dark text-light mt-2 w-25" type="submit">Edit</button>
        </form:form>
	</div>
</body>
</html>