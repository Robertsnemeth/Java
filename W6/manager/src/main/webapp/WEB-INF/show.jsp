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
<title>${project.title}</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
        <div class="d-flex justify-content-between">
            <h1>Project Details</h1>
            <a href="/dashboard">Dashboard</a>
        </div>
        <div>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Project:</td>
                        <td>Project Description:</td>
                        <td>Due Date:</td>
                    </tr>
                </thead>
                <tbody>
                    <thead>
                        <tr>
                            <td><c:out value="${project.title}"/></td>
                            <td><c:out value="${project.description}"/></td>
                            <td><c:out value="${project.dueDate}"/></td>
                        </tr>
                    </thead>
                </tbody>
            </table>
        </div>
        <a href="/ticket/new/${project.id}">Add a task</a>
	</div>
</body>
</html>