<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Buy membership</title>
    </head>
    <body>
                <h1 align="center">Type the number of months of membership you would like to buy</h1>

        <form:form id="membershipForm" modelAttribute="membership"  action="buyprocess"
		method="post">
        <table>
            <tr>
                <td> <p>1 Month - 9000 HUF. If you buy more than 3 months you will get 500 G of protein free!</p> </td>
            </tr>
            </tr>
                <td><form:label path="username">Username</form:label> </td> 
                <td><form:input path="username" name="username" id="username" /></td>
            </tr>
            <tr>                
                <td><form:label path="months">Membership in months</form:label> </td> 
                <td><form:input path="months" name="months" id="months" /></td>
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
