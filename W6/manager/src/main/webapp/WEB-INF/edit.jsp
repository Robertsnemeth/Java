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
<title>Edit ${p.title}</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
        <div class="d-flex justify-content-between">
            <h1>Edit Project</h1>
            <a href="/dashboard">Dashboard</a>
        </div>
        <div class="w-50">
            <form:form action="/project/edit/${p.id}" method="POST" modelAttribute="project" class="form">
                <input type="hidden" name="_method" value="put"/>
                <form:input type="hidden" path="user" value="${userId}"/>
                <div>
                    <form:label path="title" class="form-label">Project Title</form:label>
                    <form:errors path="title" class="text-danger"/>
                    <form:input type="text" path="title" class="form-control" value="${p.title}"/>
                </div>
                <div>
                    <form:label path="description" class="form-label">Project description</form:label>
                    <form:errors path="description" class="text-danger"/>
                    <form:input type="text" path="description" class="form-control" value="${p.description}"/>
                </div>
                <div>
                    <form:label path="dueDate" class="form-label">Due Date</form:label>
                    <form:errors path="dueDate" class="text-danger"/>
                    <form:input type="date" path="dueDate" class="form-control" value="${p.dueDate}"/>
                </div>
                <button type="submit" class="btn btn-dark text-light mt-2 w-25">Submit</button>
            </form:form>
        </div>
</body>
</html>