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
<title>${student.firstName} ${student.lastName}'s classes</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
        <h1>${student.firstName} ${student.lastName}'s classes</h1>
        <a href="/">Dashboard</a>
        <div class="mt-3 mb-3">
            <form action="/student/add/class/${student.id}" method="POST">
                <label for="c" class="form-label">Classes</label>
                <select name="c" id="">
                    <c:forEach var="cls" items="${classes}">
                        <option value="${cls.id}"><c:out value="${cls.name}"/></option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-dark text-light">Add</button>
            </form>
        </div>
        <div class="w-50">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <td>Class</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="c" items="${student.classes}">
                        <tr>
                            <td><c:out value="${c.name}"/></td>
                            <td>
                                <form action="/student/drop/${student.id}" method="POST">
                                    <input type="hidden" name="_method" value="delete">
                                    <input type="hidden" name="classId" value="${c.id}">
                                    <input type="submit" value="Drop" class="btn btn-dark text-light">
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