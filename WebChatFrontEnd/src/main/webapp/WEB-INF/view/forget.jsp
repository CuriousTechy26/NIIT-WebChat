<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${title}</title>
</head>
<body>
<h1><center>Forgot Password</center></h1>
<spring:form action="generate-otp" modelAttribute="userData" method="GET">
    
    
     <div class="form-group">
      <label for="email">EmailId:</label>
      <spring:input type="email" class="form-control" id="email" placeholder="Enter EmailId" path="email"/>
    </div>
    
    
    <button type="submit" class="btn btn-primary"> Generate OTP </button>
  </spring:form>

</body>
</html>