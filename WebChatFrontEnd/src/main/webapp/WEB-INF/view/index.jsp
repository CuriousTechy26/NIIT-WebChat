<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@include file="header.jsp" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
 <security:authorize access="hasRole('ROLE_ADMIN')">
 <jsp:forward page="/admin/Home"></jsp:forward>
 </security:authorize> 
  
  <security:authorize access="hasRole('ROLE_USER')">
 <jsp:forward page="/user/Home"></jsp:forward>
 </security:authorize>  
 
<html>
<body>
<center><h2>Welcome to WEBCHAT</h2></center>


</body>
</html>
