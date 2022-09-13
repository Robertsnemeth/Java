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
            <h1>What's your question?</h1>
            <a href="/">Home</a>
        </div>
            <div class="d-flex flex-column w-50">
                <form action="/question/new" method="POST">
                    <div>
                        <label for="question" class="form-label">Question:</label>
                        <textarea class="form-control" name="question" cols="30" rows="10"></textarea>
                    </div>
                    <div>
                        <label for="tag" class="form-label">Tags:</label>
                        <input name="tag" type="text" class="form-control"/>
                    </div>
                    <button type="submit" class="btn btn-dark txt-light mt-2 w-25">Submit</button>
                </form>
            </div>
	</div>
</body>
</html>