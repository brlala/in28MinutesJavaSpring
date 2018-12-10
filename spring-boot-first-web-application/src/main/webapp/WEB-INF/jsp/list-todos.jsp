<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Web Application</title>
</head>
<body>
	Here are the list of to-dos:
	<h1>Your todos</h1>
	<table>
	<caption>Your todos are</caption>
		<thead>
			<tr>
				<td>Description</td>
				<td>Date</td>
				<td>isDone?</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="item">
				<tr>
					<td>${item.desc}</td>
					<td>${item.targetDate}</td>
					<td>${item.done}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<a href=/add-todo>Add a todo</a>
</body>
</html>