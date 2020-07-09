<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@include file="header.jsp" %>

 ${msg}

<div class = "container">
	<div class="wrapper">
		<form action="login" method="post" name="Login_Form" class="form-signin">       
		    <h3 style="text-align:center" class="form-signin-heading"> LOGIN TO WEBCHAT</h3>
			  <hr class="colorgraph"><br>
			  
			  <div> Email: <input type="text" class="form-control" name="email" placeholder="Enter EmailId" required=""  /></div><br>
			  <div> Password: <input type="password" class="form-control" name="password" placeholder="Enter Password" required=""/></div><br>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form>
		Forgot your password?<a href="forget"> Click here. </a>			
	</div>
</div>


</body>
</html>