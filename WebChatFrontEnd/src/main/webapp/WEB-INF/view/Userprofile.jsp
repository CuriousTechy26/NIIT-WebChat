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
<title>User Profile Page</title>
</head>
<body>

<div class = "container">

<h3 class="form-signin-heading"> Profile Page</h3>
<p>Please edit or delete your account -- change</p>
			  <hr class="colorgraph"><br>
	
<c:url var="edit" value="/edit" />			  
  <spring:form action="${edit}" modelAttribute="userData" method="POST">
  
  <div class="form-group">
      <label for="userId">userId:</label>
      <spring:input type="text" class="form-control" id="userId" placeholder="Enter userId" path="userId"/>
      
    </div>
    
    <div class="form-group">
      <label for="name">Name:</label>
      
      <spring:input type="text" class="form-control" id="name" placeholder="Enter Full Name" path="name"/>
    </div>
    
    <div class="form-group">
      <label for="email">Email Id:</label>
      
      <spring:input type="email" class="form-control" id="email" placeholder="Enter Email Id" path="email"/>
    </div>
    
    <div class="form-group">
      <label for="password">Password:</label>
      
      <spring:input type="password" class="form-control" id="password" placeholder="Enter Password" path="password"/>
    </div>
    
    <div class="form-group">
      <label for="address">Address:</label>
      
      <spring:input type="text" class="form-control" id="address" placeholder="Enter Present Address" path="address"/>
    </div>
    
    <div class="form-group">
      <label for="phone">Phone Number:</label>
      
      <spring:input type="text" class="form-control" id="phone" placeholder="Enter Phone Number" path="phone"/>
    </div>
    
    
      
       <button type="submit" class="btn btn-primary"> Update  User </button>
    
    
  </spring:form>
</div>
</body>
</html>
