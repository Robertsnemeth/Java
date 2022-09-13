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
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <nav class="d-flex justify-content-between mb-3">
            <a href="/lookify/new">Add New</a>
            <a href="/lookify/topTen">Top Songs</a>
            <div>
                <form action="/lookify/dash" method="POST">
                    <input type="text" name="artist" placeholder="Search">
                    <button class="btn btn-dark text-light" type="submit">Search Artist</button>
                </form>
            </div>
        </nav>
        <div>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Title:</td>
                        <td>Rating:</td>
                        <td>Actions:</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="song" items="${looks}">
                        <tr>
                            <td><a href="/lookify/show/${song.id}">${song.title}</a></td>
                            <td><c:out value="${song.rating}"/></td>
                            <td>
                                <form action="/languages/delete/${song.id}" method="post">
                                    <input type="hidden" name="_method" value="delete">
                                    <input class="btn btn dark text-danger" type="submit" value="Delete">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>