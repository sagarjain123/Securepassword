<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center" bgcolor="pink">
<h1>Login</h1>
<form action="login.do" method="post">
<pre>
UserName:<input type="text" name="userName"><br>
Password:<input type="password" name="password"><br>
</pre>
<div>
<input type="submit" value="login">
<input type="reset" value="clear">
</div>
</form>
<h2>${msg}</h2>
</body>
</html>