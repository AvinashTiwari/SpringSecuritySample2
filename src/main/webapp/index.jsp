<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
UserName : <b><sec:authentication property="principal.username"/></b><br/>
 		<a href="/SpringSecurity/admin">Click to enter admin area</a><br/>
 		<form action="logout" method="post">
 		<input type="submit" value="Logout"/>
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 		</form>
	</body>
</html>
