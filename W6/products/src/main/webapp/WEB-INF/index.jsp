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
            <h1>Add Product to Category</h1>
            <div class="mb-2">
              <a href="/product/new">New Product</a>
              <a href="/category/new">New Category</a>
            </div>
        </div>
        <div class="row mt-2">
          <div class="col">
            <table class="table table-dark">
              <thead>
                <tr>
                  <td>Products:</td>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="product" items="${products}">
                  <tr>
                    <td><a href="/product/add/category/${product.id}"><c:out value="${product.name}"/></a></td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          <div class="col">
            <table class="table table-dark">
              <thead>
                <tr>
                  <td>Categories:</td>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="category" items="${categories}">
                  <tr>
                    <td><a href="/category/add/product/${category.id}"><c:out value="${category.name}"/></a></td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
	</div>
</body>
</html>