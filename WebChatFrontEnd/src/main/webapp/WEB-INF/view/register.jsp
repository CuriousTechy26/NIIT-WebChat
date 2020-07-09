<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>
<div class="container">
<h2>Registration</h2>
 
   <spring:form action="${pageContext.request.contextPath}/success" modelAttribute="userData" method="post">

   
    <div class="form-group">
      <label for="name">Name:</label>
      <spring:input type="text" class="form-control" id="name" placeholder="Enter Name" path="name"/>
    </div>
    
     <div class="form-group">
      <label for="email">EmailId:</label>
      <spring:input type="email" class="form-control" id="email" placeholder="Enter EmailId" path="email"/>
    </div>
    
    <div class="form-group">
      <label for="password">Password:</label>
      <spring:input type="password" class="form-control" id="password" placeholder="Enter password" path="password"/>
    </div>
    
     <div class="form-group">
      <label for="phone">PhoneNo:</label>
      <spring:input type="phone" class="form-control" id="phone" placeholder="Enter Your Mobile no here" path="phone"/>
    </div>
    
     <div class="form-group">
      <label for="address">Address:</label>
      <spring:input type="adress" class="form-control" id="address" placeholder="Enter Address" path="address"/>
    </div>
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </spring:form>
</div>

</body>
</html>