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
    <div class="container d-flex flex-column">
        <h1>Send an Omikuji!</h1>
        <form action="/login" method = "POST" class="form form-dark d-flex flex-column w-50">
            <label for="number" class="form-label">Pick any number form 5 to 25:</label>
            <select name ="number" type="text" class="form-controller w-25">
                <% for(int i = 5; i<=25; i++) { %>
                    <option value="<%= i%>"><%= i %></option>
                <% } %>
            </select>
            <label for="city" class="form-label">Enter a name of any city:</label>
            <input name="city" type="text" class="form-controller">
            <label for="person" class="form-label">Enter the name of any real person:</label>
            <input name="person" type="text" class="form-controller">
            <label for="hobby" class="form-label">Enter professional endeavor or hobby:</label>
            <input name="hobby" type="text" class="form-controller">
            <label for="thing" class="form-label">Enter any type of living thing:</label>
            <input name="thing" type="text" class="form-controller">
            <label for="statement" class="form-label">Say something nice to someone:</label>
            <textarea name="statement" type="text" class="form-controller"></textarea>
            <label for="" class="form-label">Send and show a friend!</label>
            <button type="submit" class="btn btn-dark text-light w-25">Send</button>
        </form>
    </div>
</body>
</html>