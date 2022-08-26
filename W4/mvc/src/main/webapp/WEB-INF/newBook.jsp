<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
        <form:form action="/books/new/add" method="Post" class="form w-50 d-flex flex-column" modelAttribute="book">
            <form:label path="title" class="form-label">Title</form:label>
            <form:errors path="title" class="text-danger"/>
            <form:input path="title" type="text" class="form-control"/>
            <form:label path="description" class="form-label">Description</form:label>
            <form:errors path="description" class="text-danger"/>
            <form:textarea path="description" id="" cols="30" rows="10"></form:textarea>
            <form:label path="language" class="form-label">Language</form:label>
            <form:errors path="language" class="text-danger"/>
            <form:input path="language" type="text" class="form-control"/>
            <form:label path="numberOfPages" class="form-label">Pages</form:label>
            <form:errors path="numberOfPages" class="text-danger"/>           
            <form:input path="numberOfPages" type="text" class="form-control"/>
            <button class="btn btn-dark text-light mt-2 w-25" type="submit">Add Book</button>
        </form:form>
	</div>
</body>
</html>