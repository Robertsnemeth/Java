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
<title>Add a Question</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
        <div class="d-flex justify-content-between">
            <h1>${question.question}?</h1>
            <a href="/">Home</a>
        </div>
        <div class="d-flex align-items-center">
            <h2>Tags:</h2>
            <ul class="ms-2">
                <c:forEach var="tag" items="${question.tags}">
                    <li><c:out value="${tag.tag}"/></li>
                </c:forEach>
            </ul>
        </div>
        <div class="row">
            <div class="col">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <td>Answers:</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="answer" items="${question.answers}">
                            <tr>
                                <td><c:out value="${answer.answer}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col">
                <h2>Add your answer:</h2>
                <form:form action="/answer/new/${question.id}" method="POST" modelAttribute="answers">
                    <form:input type="hidden" path="question" value="${question.id}"/>
                    <div>
                        <form:label path="answer" class="form-label">Answer:</form:label>
                        <form:errors path="answer" class="text-danger"/>
                        <form:textarea class="form-control" path="answer" cols="30" rows="10"></form:textarea>
                    </div>
                    <button type="submit" class="btn btn-dark txt-light mt-2 w-25">Submit</button>
                </form:form>
            </div>
        </div>
	</div>
</body>
</html>