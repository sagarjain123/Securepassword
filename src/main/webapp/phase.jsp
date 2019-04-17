<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Set Phase</title>
</head>
<body bgcolor="red">
<form action="securePhrase.do" method="get">
<pre>
userName:<input type="text" name="userName" value="${user}"readonly="readonly">
Secure Phase:<input type="text" name="securePhase">
<input type="submit" name="submit" value="submit">
<input type="reset" name="clear" value="clear">
</pre>
</form>
</body>
</html>