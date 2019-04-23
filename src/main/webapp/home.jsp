<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<h1>${msg}</h1>
<a href="UserCredential.jsp">Add</a>
<table align="center" border="2">
  <tr>
     <th>App Name</th>
     <th>URL</th>
     <th>UserID</th>
     <th>View Password</th>
     <th>Edit</th>
     <th>Delete</th>
   </tr>
    <c:forEach var="cDTO" items="${list}">
    <tr>
      <td>${cDTO.name}</td>
      <td>${cDTO.url}</td>
      <td>${cDTO.userId}</td>
      <td>${cDTO.password}</td>
      <td><a href="editCredential.do?name=${cDTO.name}&&user=${UserEntity.userName}">Edit</a></td>
      <td><a href="deleteCredential.do?name=${cDTO.name}&&user=${UserEntity.userName}">Delete</a></td>
      
      </tr>
      </c:forEach>
</table>
</body>
</html>