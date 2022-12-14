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
        <h1>Save Travels</h1>
        <div>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Expense:</td>
                        <td>Vendor:</td>
                        <td>Amount:</td>
                        <td>Actions:</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="expense" items="${expenses}">
                        <tr>
                            <td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
                            <td><c:out value="${expense.vendor}"/></td>
                            <td>$<c:out value="${expense.amount}"/></td>
                            <td>
                                <div class="d-flex flex-row justify-content-around align-items-center">
                                    <a href="/expenses/edit/${expense.id}">Edit</a>|
                                    <form action="/expenses/delete/${expense.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input class="btn btn dark text-danger" type="submit" value="Delete">
                                    </form>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="container p-5">
            <h2>Add Expense</h2>
            <form:form action="/expenses/add" method="POST" class="form d-flex flex-column w-50" modelAttribute="travels">
                <div>
                    <form:label path="name" class="form-label">Expense Name:</form:label>
                    <form:errors path="name" class="text-danger"/>
                    <form:input path="name" type="text" class="form-control"/>
                </div>
                <div>
                    <form:label path="vendor" class="form-label">Vendor:</form:label>
                    <form:errors path="vendor" class="text-danger"/>
                    <form:input path="vendor" type="text" class="form-control"/>
                </div>
                <div>
                    <form:label path="amount" class="form-label">Amount:</form:label>
                    <form:errors path="amount" class="text-danger"/>
                    <form:input path="amount" type="text" class="form-control"/>
                </div>
                <div>
                    <form:label path="description" class="form-label">Description:</form:label>
                    <form:errors path="description" class="text-danger"/>
                    <form:textarea path="description" type="text" class="form-control"></form:textarea>
                </div>
                <button class="btn btn-dark text-light mt-2 w-25" type="submit">Add</button>
            </form:form>
        </div>
	</div>
</body>
</html>