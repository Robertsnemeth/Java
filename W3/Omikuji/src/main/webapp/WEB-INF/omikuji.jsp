<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container d-flex flex-column align-items-center border border-dark bg-primary text-light w-25 mt-5">
        <h1>Here's Your Omikuji!</h1>
        <div class="container d-flex flex-column align-items-center">
            <p>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, <c:out value="${hobby}"/> for a living. The next time you see a <c:out value="${thing}"/>, you will have good luck. Also, <c:out value="${statement}"/>.</p>
        </div>
        <a href="/home" class="btn btn-info text-light">Go back home</a>
    </div>
</body>
</html>