<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Buy membership</title>
    </head>
    <body>
        
        <form:form id="membershipForm" modelAttribute="user" action="buyprocess"
		method="post">
        <h1 align="center">Type the number of months of membership you would like to buy</h1>
        <table>
            <tr>
                <td> <p>1 Month - 9000 HUF. If you buy more than 3 months you will get 500 G of protein free!</p> </td>
                <td><form:label path="memberShip">Membership in months</form:label> </td>
                <td><form:input path="memberShip" id="membership" /></td>
            </tr>
            <tr>
		<td></td>
		<td><form:button id="buy" name="buy">Buy</form:button></td>
            </tr>
            <tr>
		<td></td>
		<td><a href="home.jsp">Home</a></td>
            </tr>
        </table>
        </form:form>
    </body>
</html>
