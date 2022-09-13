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
<title>Languagess</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column p-5">
        <h1>Languages</h1>
        <div>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Language:</td>
                        <td>Creator:</td>
                        <td>Version:</td>
                        <td>Actions:</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="language" items="${languages}">
                        <tr>
                            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
                            <td><c:out value="${language.creator}"/></td>
                            <td><c:out value="${language.version}"/></td>
                            <td>
                                <div class="d-flex flex-row justify-content-around align-items-center">
                                    <a href="/languages/edit/${language.id}">Edit</a>|
                                    <form action="/languages/delete/${language.id}" method="post">
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
            <h2>Add Language</h2>
            <form:form action="/languages/add" method="POST" class="form d-flex flex-column w-50" modelAttribute="language">
                <div>
                    <form:label path="name" class="form-label">Language Name:</form:label>
                    <form:errors path="name" class="text-danger"/>
                    <form:input path="name" type="text" class="form-control"/>
                </div>
                <div>
                    <form:label path="creator" class="form-label">Creator:</form:label>
                    <form:errors path="creator" class="text-danger"/>
                    <form:input path="creator" type="text" class="form-control"/>
                </div>
                <div>
                    <form:label path="version" class="form-label">Version:</form:label>
                    <form:errors path="version" class="text-danger"/>
                    <form:input path="version" type="text" class="form-control"/>
                </div>
                <button class="btn btn-dark text-light mt-2 w-25" type="submit">Add</button>
            </form:form>
        </div>
	</div>
</body>
</html>