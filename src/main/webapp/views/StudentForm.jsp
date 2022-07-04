<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="save" method="post">
<%-- Displaying Student Management Data in the form of a table  --%>
<table>
<tr>
<td>Name</td><td><input type="text" value="${student.name}" name="name"/> </td></tr>
<tr>
<td>Departement</td><td><input type="text" value="${student.departement}" name="departement"/> </td>
</tr>
<tr>
<td>Country</td><td><input type="text" value="${student.country}" name="country"/> </td>
</tr>
<tr>
<td colspan="2"><input type="hidden" value='${student.studentid}' name="studentid"/><input type="submit"/></td></tr>
</table>

</form>
</body>
</html>