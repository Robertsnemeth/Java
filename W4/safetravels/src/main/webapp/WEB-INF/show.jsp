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
<title>Save Travels</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column p-5">
        <div class="d-flex justify-content-between">
            <h1>Expense Details</h1>
            <a href="/">Home</a>
        </div>
        <div>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Expense:</td>
                        <td>Vendor:</td>
                        <td>Amount:</td>
                        <td>Description:</td>
                        <td>Actions:</td>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><c:out value="${expense.name}"/></td>
                            <td><c:out value="${expense.vendor}"/></td>
                            <td><c:out value="${expense.amount}"/></td>
                            <td><c:out value="${expense.description}"/></td>
                            <td><a href="/expenses/edit/${expense.id}">Edit</a>|<a href="/expenses/delete/${expense.id}">Delete</a></td>
                        </tr>
                </tbody>
            </table>
        </div>
	</div>
</body>
</html>