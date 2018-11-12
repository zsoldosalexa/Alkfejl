<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Delete lesson</title>
    </head>
    <body>
            <h1 align="center">Type ID of the lesson you want to delete</h1>

        <form:form id="deleteLessonForm" modelAttribute="deletelesson"  action="deletedlesson"
		method="post">
        <table>
            <tr>
                <td><form:label path="id">id</form:label> </td> 
                <td><form:input path="id" name="id" id="id" /></td>
            </tr>
            <tr>
		<td></td>
		<td><form:button id="submit">Submit</form:button></td>
            </tr>
            <tr>
		<td><a href="home.jsp">Home</a></td>
            </tr>
        </table>
        </form:form>
    </body>
</html>
