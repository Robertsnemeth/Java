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
<title>Language</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column p-5">
        <div class="d-flex justify-content-between">
            <h1>Language Details</h1>
            <a href="/">Home</a>
        </div>
        <div>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Language:</td>
                        <td>Created by:</td>
                        <td>Version:</td>
                        <td>Actions:</td>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><c:out value="${language.name}"/></td>
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
                </tbody>
            </table>
        </div>
	</div>
</body>
</html>