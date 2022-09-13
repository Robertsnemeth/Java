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
<title>${book.title}'s Dashboard</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <div class="d-flex justify-content-between">
            <h1>${book.title}</h1>
            <a href="/dashboard">Back to the Bookshelf</a>
        </div>
        <c:choose> 
            <c:when test="${userId == book.user.id}">
                <div class="container">
                    <h2><span class="text-danger">You</span> read <span class="text-info">${book.title}</span> by <span class="text-success">${book.author}</span></h2>
                    <h3>Here are your thoughts:</h3>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <h2><span class="text-danger">${book.user.userName}</span> read <span class="text-info">${book.title}</span> by <span class="text-success">${book.author}</span></h2>
                    <h3>Here are ${book.user.userName}'s thoughts:</h3>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="container border-top border-1 border-bottom border-1">
            <p>${book.thoughts}</p>
        </div>
        <c:if test="${userId == book.user.id}">
			<div class="d-flex justify-content-end mt-2">
	            <div class="ms-2">
	                <a class="btn btn-dark text-light" href="/book/edit/${book.id}" >Edit</a>
	            </div>
	            <div class="ms-2">
	                <form action="/book/delete/${book.id}" method="POST">
	                    <input type="hidden" name="_method" value="delete">
	                    <input class="btn btn-dark text-light" type="submit" value="Delete"/>
	                </form>
	            </div>
        	</div>
		</c:if>
	</div>
</body>
</html>