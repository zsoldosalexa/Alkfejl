<%-- 
    Document   : lessons
    Created on : 2018.11.05., 0:54:38
    Author     : bzolt
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserve place</title>
    </head>
    <body>
        <form:form id="reserveForm" modelAttribute="lessons" action="reserveprocess" method="post">       
        <table align="center">
             <tr>
                <td> Date </td>
                <td> Name </td>
                <td> Begin </td>
                <td> End </td>
                <td> Trainer </td>
                <td> Available places </td>
            </tr>
        <%
            try {
                String query="Select * from lessons";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers","root","root");
                Statement stm=conn.createStatement();
                ResultSet rs=stm.executeQuery(query);
                while (rs.next()) {
                %>
                    <tr>
                        <td> <%=rs.getString("date")%> </td> 
                        <td> <%=rs.getString("name")%> </td>
                        <td> <%=rs.getInt("begin")%> </td>
                        <td> <%=rs.getInt("end")%> </td>
                        <td> <%=rs.getString("trainer")%> </td>
                        <td> <%=rs.getInt("availableplaces")%> </td>
                    </tr>
                <%
                }
            }
            catch(Exception ex) {
                ex.printStackTrace();
                out.println("Error "+ex.getMessage() );
            }
        %>
        </table>
        <br>
        <center>
            <form:label path="name" > Type the name of the lesson you would like to attend (only one) </form:label>
            <form:input path="name" id="name" name="name" />
            <form:button id="reserveprocess" name="reserveprocess">Reserve</form:button>
        </center>
        </form:form>
    </body>
</html>
