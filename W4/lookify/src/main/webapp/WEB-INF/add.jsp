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
<title>Add Song</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
  <div class="container">
    <a href="/lookify/dash" class="d-flex justify-content-end">Dashboard</a>
    <form:form action="/lookify/add" method="POST" modelAttribute="songs" class="w-50">
      <div>
        <form:label path="title" class="form-label">Title:</form:label>
        <form:errors path ="title" class="text-danger"/>
        <form:input path="title" type="text" class="form-control"/>
      </div>
      <div>
        <form:label path="artist" class="form-label">Artist:</form:label>
        <form:errors path ="artist" class="text-danger"/>
        <form:input path="artist" type="text" class="form-control"/>
      </div>
      <div>
        <form:label path="rating" class="form-label">Rating(1-10):</form:label>
        <form:errors path ="rating" class="text-danger"/>
        <form:input path="rating" type="number" class="form-control w-25" min="0" max="10"/>
      </div>
      <button class="btn btn-dark text-light mt-2" type="submit">Add Song</button>
    </form:form>
  </div>
</body>
</html>