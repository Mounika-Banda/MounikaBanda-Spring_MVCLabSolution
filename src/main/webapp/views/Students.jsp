<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table><tr><td><a href="addStudent">Add a new Student</a></td></table>
<form action="search" method="post">
<table>
<tr><td>Name</td><td><input type="text" name="name"/></td></tr>
<tr><td>Departement</td><td><input type="text" name="departement"/></td></tr>
<tr><td colspan="2"><input type="submit"/></td></tr>
</table>
</form>

${error}

<table border="1">
<tr>
<th>Id</th><th>Name</th><th>Departement</th><th>Country</th><th>Action</th>
</tr>
<c:forEach items="${students}" var="b">
<tr>
<td>${b.studentid}</td>
<td>${b.name}</td>
<td>${b.departement}</td>
<td>${b.country }</td>
<td><a href="addStudent?id=${b.studentid}">Update</a><a href="deleteStudent?id=${b.studentid}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>