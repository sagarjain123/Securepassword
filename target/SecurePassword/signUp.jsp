<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink" align="center">
<form action="signUp.do" method="post">
<pre>
Email:<input type="email" name="email"><br>
UserName:<input type="text" name="userName"><br>
MobilNo:<input type="number" name="mobileNo"><br>
Type:<br>
Professional<input type="radio" name="type" value="Professional">
Personal<input type="radio" name="type" value="Personal">
</pre>
<div>
<input type="submit" value="submit">
<input type="reset" value="clear">
</div>

</form>

</body>
</html>