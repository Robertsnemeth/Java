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
<title>Top Ten</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <nav class="d-flex justify-content-between mb-3">
        <h1>Top Ten Songs</h1>
        <a href="/lookify/dash">Dashboard</a>
    </nav>
    <div>
        <table class="table table-dark">
            <thead>
                <tr>
                    <td>Rating:</td>
                    <td>Title:</td>
                    <td>Artist:</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="song" items="${topSongs}">
                    <tr>
                        <td><c:out value="${song.rating}"/></td>
                        <td><c:out value="${song.title}"/></td>
                        <td><c:out value="${song.artist}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>