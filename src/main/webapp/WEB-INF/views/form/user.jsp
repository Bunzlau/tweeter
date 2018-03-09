<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejestracja</title>
</head>
<body>
	<h1>Rejestracja</h1>
	<form:form modelAttribute="user" method="post" action="user/register">
		<form:errors path="*"></form:errors>
		<form:input path="userName" placeholder="Username" />
		<br>
		<form:errors path="userName" />
		<br>
		<form:password path="password" placeholder="password"/>
		<br>
		<form:errors path="password" />
		<br>
		<form:input type="email" path="email" placeholder="email" />
		<br>
		<form:errors path="email" />
		<br>
		<input type="submit" value="Potwierdź">
	</form:form>
</body>
</html>