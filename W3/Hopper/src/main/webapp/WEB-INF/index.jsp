<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper Assignment</title>
<link rel="stylesheet" type="text/css" href = "/css/style.css">
	<script type = "text/javascript" src = "js/app.js"></script>
	<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
	<div class="container this_div">
		<div>
			<h1>Customer Name: <c:out value="${name}"/></h1>
			<h2>Item Name: <c:out value="${itemName }"/></h2>
			<h2>Price: $<c:out value="${price }"/></h2>
			<h2>Description: <c:out value="${description }"/></h2>
			<h2>Vendor: <c:out value="${vendor }"/></h2>
		</div>
		<div class="row mt-2">
			<div class="col"><a href="/date">Date Template</a></div>
			<div class="col"><a href="/time">Time Template</a></div>
		</div>
	</div>
</body>
</html>