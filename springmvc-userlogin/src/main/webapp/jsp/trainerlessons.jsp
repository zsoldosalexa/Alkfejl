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
        <title>Lessons</title>
    </head>
    <body>
        <center>
            <h1 align="center">Type username</h1>

        <form:form id="lessonForm" modelAttribute="trainerlessons"  action="showlessons"
		method="post">
        <table>
            </tr>
                <td><form:label path="trainerUsername">Username</form:label> </td> 
                <td><form:input path="trainerUsername" name="trainerUsername" id="trainerUsername" /></td>
            </tr>
            <tr>
		<td></td>
		<td><form:button id="submit">Submit</form:button></td>
            </tr>
            <tr>
		<td> 
                <%
            try {
                String query="Select * from lessons where trainerusername='"+(String) request.getParameter("trainerUsername")+"'";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers","root","root");
                Statement stm=conn.createStatement();
                ResultSet rs=stm.executeQuery(query);
                while (rs.next()) {
                %>
                    <tr>
                        <tr>
                            <td> ID </td>
                            <td> Date </td>
                            <td> Begin </td>
                            <td> End </td>
                            <td> Name </td>
                            <td> Trainer </td>
                            <td> Available places </td>
                        </tr>
                        <td> <%=rs.getInt("ID")%> </td> 
                        <td> <%=rs.getString("date")%> </td> 
                        <td> <%=rs.getInt("begin")%> </td>
                        <td> <%=rs.getInt("end")%> </td>
                        <td> <%=rs.getString("name")%> </td>
                        <td> <%=rs.getString("trainer")%> </td>
                        <td> <%=rs.getString("availableplaces")%> </td>
                    </tr>
                <%
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
                out.println("Error "+ex.getMessage() );
            }
        %>
        </td>
		<td><a href="home.jsp">Home</a></td>
            </tr>
        </table>
        </form:form>
        </center>
    </body>
</html>
