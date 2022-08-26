<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gold</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <div class="container d-flex flex-column">
        <div class="d-flex align-items-center">
            <h1 class="me-2">Your Gold:</h1>
            <h2><c:out value="${gold}"/></h2>
        </div>
        <div class="d-flex justify-content-between">
            <div class="d-flex flex-column align-items-center justify-content-around border border-dark p-5">
                <h1>Farm</h1>
                <p>(earns 10-20 gold)</p>
                <form action="/gold/add" method="post">
                    <input class="btn btn-dark" type="submit" name = "gold10" value="Find Gold!">
                </form>
            </div>
            <div class="d-flex flex-column align-items-center justify-content-around border border-dark p-5">
                <h1>Cave</h1>
                <p>(earns 5-10 gold)</p>
                <form action="/gold/add" method="post">
                    <input class="btn btn-dark" type="submit" name = "gold5" value="Find Gold!">
                </form>
            </div>
            <div class="d-flex flex-column align-items-center justify-content-around border border-dark p-5">
                <h1>House</h1>
                <p>(earns 2-5 gold)</p>
                <form action="/gold/add" method="post">
                    <input class="btn btn-dark" type="submit" name = "gold2" value="Find Gold!">
                </form>
            </div>
            <div class="d-flex flex-column align-items-center justify-content-around border border-dark p-5">
                <h1>Quest</h1>
                <p>(earns 0-50 gold)</p>
                <form action="/gold/add" method="post">
                    <input class="btn btn-dark" type="submit" name = "gold50" value="Find Gold!">
                </form>
            </div>
            <div class="d-flex flex-column align-items-center justify-content-around border border-dark p-5">
                <h1>Spa</h1>
                <p>(lose 5-20 gold)</p>
                <form action="/gold/add" method="post">
                    <input class="btn btn-dark" type="submit" name = "spa" value="Find Gold!">
                </form>
            </div>
        </div>
        <div class="d-flex flex-column justify-content-between">
            <h1>Activities</h1>
            <textarea name="" id="" cols="30" rows="10">
                <c:forEach var="activity" items="${activities}">
                        <c:out value="${activity}"></c:out>
                </c:forEach>
            </textarea>
        </div>
        <form action="/gold/add" method="post">
            <input class="btn btn-dark mt-2" type="submit" name = "reset" value="Reset Gold">
        </form>
    </div>
</body>
</html>