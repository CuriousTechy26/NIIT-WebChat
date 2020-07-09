<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>${title}</title></head>
<body>
<div class = "container">
	<div class="wrapper">
  <spring:form action="passwordUpdate" modelAttribute="userData" method="POST">
  <h3 class="form-signin-heading">Update Password</h3>
    <hr class="colorgraph"><br>
    
    
       <div class="form-group">
      <label for="password">Password:</label>
      <spring:input type="password" class="form-control" id="password" placeholder="Enter password" path="password"/>
     
    </div>
    
     <div class="form-group">
      <label for="confirmPassword">Confirm Password:</label>
      <spring:input type="password" class="form-control" id="confirmPassword" placeholder="Enter confirm Password" path="confirmPassword"/>
     
    
    
     <button class="btn btn-lg btn-primary btn-block">Submit</button>  
    
  </spring:form>
  </div>
</div>
</body>
</html>





