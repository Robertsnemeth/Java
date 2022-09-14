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
<title>${user.userName}'s Dashboard</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<div class="container d-flex flex-column">
        <div class="d-flex justify-content-between">
            <h1>Welcome ${user.userName}</h1>
            <a href="/logout">Logout</a>
        </div>
        <div class="d-flex justify-content-between align-items-center">
          <h1>All Projects</h1>
          <a href="/project/new" class="btn btn-dark text-light">+ New Project</a>
        </div>
        <div class="mt-4 mb-4">
          <table class="table table-dark">
            <thead>
              <tr>
                <td>Project:</td>
                <td>Team Lead:</td>
                <td>Due Date:</td>
                <td>Actions:</td>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="project" items="${unassigned}">
                <tr>
                  <td><c:out value="${project.title}"/></td>
                  <td><c:out value="${project.user.userName}"/></td>
                  <td><c:out value="${project.dueDate}"/></td>
                  <td>
                    <form action="/project/join/${user.id}" method="POST">
                      <input type="hidden" name="projectId" value="${project.id}">
                      <input type="submit" class="btn btn-dark text-success" value="Join Team">
                    </form>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
        <h1>Your Projects</h1>
        <div class="mt-4 mb-4">
          <table class="table table-dark">
            <thead>
              <tr>
                <td>Project:</td>
                <td>Team Lead:</td>
                <td>Due Date:</td>
                <td>Actions:</td>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="project" items="${userProjects}">
                <tr>
                  <td><a href="/project/show/${project.id}"><c:out value="${project.title}"/></a></td>
                  <td><c:out value="${project.user.userName}"/></td>
                  <td><c:out value="${project.dueDate}"/></td>
                  <td class="d-flex">
                    <c:if test="${user.id != project.user.id}">
                      <form action="/project/leave/${user.id}" method="POST">
                        <input type="hidden" name="projectId" value="${project.id}">
                        <input type="submit" class="btn btn-dark text-danger" value="Leave Project">
                      </form>
                    </c:if>
                    <c:if test="${user.id == project.user.id}">
                      <form action="/project/delete/${project.id}" method="POST">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" class="btn btn-dark text-danger" value="Delete">
                      </form>
                      <a class="btn btn-dark text-success" href="/project/edit/${project.id}">Edit</a>
                    </c:if>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
	</div>
</body>
</html>