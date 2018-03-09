<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logowanie</title>
</head>
<body>
<h2>${param.message}</h2>
<form method="POST">
	<input type="text" name="userName" placeholder="userName/email"><br>
	<input type="password" name="password" placeholder="password"><br>	
	<input type="submit" value="zaloguj"><br>
</form>
</body>
</html>