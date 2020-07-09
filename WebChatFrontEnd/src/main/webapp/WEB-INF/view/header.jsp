<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web chat</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="index">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar"> 
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
     <security:authorize access="isAnonymous()">
     
      <li class="nav-item">
        <a class="nav-link" href="login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="register">Register</a>
      </li>
      </security:authorize>
      <security:authorize access="hasRole('ROLE_USER')">			
      
      <li class="nav-item">
        <a class="nav-link" href="update">Profile</a>
      </li>
      </security:authorize>
      <security:authorize access="hasRole('ROLE_USER')">			
      
      <li class="nav-item">
        <a class="nav-link" href="chat">Chat</a>
      </li>
      </security:authorize>
      
      <security:authorize access="isAuthenticated()" >
      <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>   
      </security:authorize> 
    </ul>
  </div>    
</nav>
</body>
</html>
