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
<title>${user.userName}'s Bookmarket</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <div class="d-flex justify-content-between">
            <div>
                <h2>Hello ${user.userName}. Weclome to...</h2>
                <h1>The Book Broker!</h1>
            </div>
            <div>
                <a href="/logout">Logout |</a>
                <a href="/dashboard">Back to my shelf!</a>
            </div>
        </div>
        <div>
            <h2>Available Books to Borrow:</h2>
            <table class="table table-dark">
            <thead>
                <tr>
                <td>ID:</td>
                <td>Title:</td>
                <td>Author Name:</td>
                <td>Owner:</td>
                <td>Actions:</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                <tr>
                    <td><c:out value="${book.id}"/></td>
                    <td><a href="/book/show/${book.id}"><c:out value="${book.title}"/></a></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.user.userName}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${userId == book.user.id}">
                                <div class="d-flex">
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
                            </c:when>
                            <c:otherwise>
                                <c:if test="${userId != book.borrowed.id}">
                                    <a href="/book/borrow/${book.id}" class="btn btn-dark text-light">Borrow</a>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            </table>
        </div>
        <div>
            <h2>Books I'm Borrowing:</h2>
            <table class="table table-dark">
            <thead>
                    <tr>
                    <td>ID:</td>
                    <td>Title:</td>
                    <td>Author Name:</td>
                    <td>Owner:</td>
                    <td>Actions:</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="borrowed" items="${borrow}">
                <tr>
                    <td><c:out value="${borrowed.id}"/></td>
                    <td><a href="/book/show/${borrowed.id}"><c:out value="${borrowed.title}"/></a></td>
                    <td><c:out value="${borrowed.author}"/></td>
                    <td><c:out value="${borrowed.user.userName}"/></td>
                    <td><a href="/book/return/${borrowed.id}" class="btn btn-dark text-light">Return</a></td>
                </tr>
                </c:forEach>
            </tbody>
            </table>
        </div>
	</div>
</body>
</html>