<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add lesson</title>
</head>
<body>
	<form:form id="newlessonForm" modelAttribute="newlesson" action="addlesson"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="date">Date (yyyy-mm-dd)</form:label></td>
				<td><form:input path="date" name="date" id="date" /></td>
			</tr>
			<tr>
				<td><form:label path="begin">Begin</form:label></td>
				<td><form:input path="begin" name="begin"
						id="begin" /></td>
			</tr>
			<tr>
				<td><form:label path="end">End</form:label></td>
				<td><form:input path="end" name="end"
						id="end" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:label path="trainer">Trainer</form:label></td>
				<td><form:input path="trainer" name="trainer" id="trainer" /></td>
			</tr>
			<tr>
				<td><form:label path="availablePlaces">Available Places</form:label></td>
				<td><form:input path="availablePlaces" name="availablePlaces" id="availablePlaces" /></td>
			</tr>
			<tr>
				<td><form:label path="trainerUsername">Trainer Username</form:label></td>
				<td><form:input path="trainerUsername" name="trainerUsername" id="trainerUsername" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="add" name="add">Add</form:button></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="home.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
