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
<title>Question Dashboard</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
            <h1>Questions Dashboard</h1>
            <div>
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <td>Question:</td>
                            <td>Tags:</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="question" items="${questions}">
                            <tr>
                                <td><a href="/answer/new/${question.id}"><c:out value="${question.question}"/></a></td>
                                <c:forEach var="tag" items="${question.tags}">
                                    <td><c:out value="${tag.tag}"/></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="/question/new">New Question</a>
	</div>
</body>
</html>