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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <div class="d-flex justify-content-between border-bottom border-dark">
            <div class="mb-2">
                <h1>${product.name}</h1>
                <a href="/">Home</a>
            </div>
        </div>
        <div>
            <table class="table table-dark border-bottom border-dark mb-2">
                <thead>
                    <tr>
                        <td>Categories:</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="category" items="${product.categories}">
                        <tr>
                            <td>- <c:out value="${category.name}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
            </table>
        </div>
        <div class="mt-2">
            <h1>Add Category:</h1>
            <form action="/product/add/category/${product.id}" method="POST">
                <select name="categoryId" id="categoryId">
                    <c:forEach var="category" items="${categories}">
                    <option value="${category.id}"><c:out value="${category.name}"/></option>
                </c:forEach>
                </select>
                <button type="submit" class="btn btn-dark text-light">Add</button>
            </form>
        </div>
	</div>
</body>
</html>