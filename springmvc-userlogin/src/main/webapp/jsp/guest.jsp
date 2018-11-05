<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Szemlélet Gym</title>
    </head>
    <body>
        <h1 align="center">Greetings ${firstname}</h1>
        <table>
		<tr>
                    <td><a href="jsp/membership.jsp"> Buy membership</a></td>
                    <td><a href="jsp/lessons.jsp"> Lessons </a> </td>
                    <td> <a href="jsp/ask.jsp"> Ask something </a></td>
		</tr>
		<tr>
		</tr>
		<tr>
		</tr>
		<tr>
                    <td><a href="home.jsp">Home</a></td>
		</tr>
	</table>
    </body>
</html>
