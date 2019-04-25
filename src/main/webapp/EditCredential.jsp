<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Credentials</h1>

<form action="updateCredential.do" method="post">
 Name:<input type="text" name="name" value="${cdto.name}">
 URL:<input type="text" name="url" value="${cdto.url}">
 userID:<input type="text" name="userId" value="${cdto.userId}">
 Password:<input type="text" name="password" value="${cdto.password}">
 Note:<input type="text" name="note" value="${cdto.note}">
<input type="submit" value="Update">
<input type="reset" value="clear">

</form>
</body>
</html>