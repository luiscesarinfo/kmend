<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Manager</title>
		<script>
			function myFunction() {
			    alert("hahaha");
			}		
		</script>
	</head>
	<body>
		<div align="center">
			<h2>User Manager</h2>
			<form method="get" action="search">
				<input type="text" name="keyword" /> &nbsp; <input type="button" value="Search" onclick="myFunction()"/>
			</form>
			<h3>
				<a href="/new">New user</a>
			</h3>
			<table border="1" cellpadding="5">
				<tr>
					<th>ID</th>
					<th>Birthday</th>
					<th>Spend</th>
					<th>Region</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${listUser}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.birthday}</td>
						<td>${user.spend}</td>
						<td>${user.region}</td>
						<td><a href="/edit?id=${user.id}">Edit</a>
							&nbsp;&nbsp;&nbsp; <a href="/delete?id=${user.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>