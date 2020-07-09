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
  <spring:form action="otpverify" modelAttribute="userData" method="GET">
  <h3 class="form-signin-heading">${title }</h3>
    <hr class="colorgraph"><br>
    
    <div class="form-group">
      <label for="otp">Enter your OTP here :</label>
      <spring:input type="otp" class="form-control" id="otp" placeholder="Enter otp" path="otp"/>
    </div>
       
    
     <button class="btn btn-lg btn-primary btn-block">Verify OTP</button>  
    
  </spring:form>
  </div>
</div>
</body>
</html>





