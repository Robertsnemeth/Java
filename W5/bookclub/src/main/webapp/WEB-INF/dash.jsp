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
<title>${user.userName}'s Bookshelf</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <div class="d-flex justify-content-between">
            <h1>Welcome ${user.userName}</h1>
            <div>
              <a href="/logout">Logout</a>
              <a href="/book/broker/${user.id}">Book Broker</a>
            </div>
        </div>
        <div class="d-flex justify-content-between m-2">
          <h2>Books from everyone's shelf:</h2>
          <a href="/book/add">Add to my shelf!</a>
        </div>
        <div>
          <table class="table table-dark">
            <thead>
              <tr>
                <td>ID:</td>
                <td>Title:</td>
                <td>Author Name:</td>
                <td>Posted By:</td>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="book" items="${books}">
                <tr>
                  <td><c:out value="${book.id}"/></td>
                  <td><a href="/book/show/${book.id}"><c:out value="${book.title}"/></a></td>
                  <td><c:out value="${book.author}"/></td>
                  <td><c:out value="${book.user.userName}"/></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
	</div>
</body>
</html>