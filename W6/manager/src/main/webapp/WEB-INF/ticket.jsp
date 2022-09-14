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
<title>${project.title} Task's</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
        <div class="d-flex justify-content-between">
            <h1>Project: ${project.title}</h1>
            <a href="/dashboard">Dashboard</a>
        </div>
        <h4>Project Lead: ${project.user.userName}</h4>
        <div class="d-flex">
            <form:form action="/ticket/new/${project.id}" method="POST" modelAttribute="tickets" class="form">
                <form:input type="hidden" path="userTix" value="${userId}"/>
                <form:input type="hidden" path="project" value="${project.id}"/>
                <div class="d-flex">
                    <form:label path="ticket" class="form-label">Add a task ticket for this team:</form:label>
                    <form:errors path="ticket" class="text-danger"/>
                    <form:textarea path="ticket" class="form-control" cols="30" rows="10"></form:textarea>
                </div>
                <button class="btn btn-dark text-light mt-2 w-25 align-self-end">Add</button>
            </form:form>
        </div>
        <div>
            <h2>Tasks</h2>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Added By:</td>
                        <td>Task:</td>
                        <td>Added:</td>
                    </tr>
                </thead>
                <tbody>
                    <thead>
                        <c:forEach var = "task" items="${project.tickets}">
                            <tr>
                                <td><c:out value="${task.userTix.userName}"/></td>
                                <td><c:out value="${task.ticket}"/></td>
                                <td><c:out value="${task.createdAt}"/></td>
                            </tr>
                        </c:forEach>
                    </thead>
                </tbody>
            </table>
        </div>
	</div>
</body>
</html>