<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="blue">
<form action="ChangePassword.do" method="post">
<pre>
userName :<input type="text" name="userName">
oldPassword :<input type="text" name="oldPassword">
newPassword :<input type="text" name="newPassword">
confirmPassword :<input type="text" name="confirmPassword">
securePhase :<input type="text" name="securePhase">
</pre>
<div>
<input type="submit" name="submit" value="submit">
<input type="reset" name="clear" value="clear">
</div>
</form>
</body>
</html>