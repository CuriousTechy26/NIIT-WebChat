<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<center><h2>Welcome to Admin Page</h2></center>

<div class="container">
  <h2>User List</h2>
            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Emailid</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Delete</th>
        <th>Update</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${userList}" var="userData">
      <tr>
        <td>${userData.name}</td>
        <td>${userData.email}</td>
        <td>${userData.address}</td>
        <td>${userData.phone}</td>
        <td><a href="<c:url value='/delete/${userData.userId}'/>">Delete</a></td>
        <td><a href="<c:url value='/update/${userData.userId}'/>">Update</a></td>
      </tr>
      </c:forEach>
            </table>
      </div>
</body>
</html>