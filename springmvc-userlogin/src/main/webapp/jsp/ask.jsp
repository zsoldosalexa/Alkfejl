<%-- 
    Document   : ask
    Created on : 2018.11.05., 1:29:24
    Author     : bzolt
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="mailto:hehe@hehe">

            <label for="fname">First Name</label>
            <input type="text" id="fname" name="firstname" placeholder="Your name..">
            <br>
            <label for="lname">Last Name</label>
            <input type="text" id="lname" name="lastname" placeholder="Your last name..">
            <br>
            <label for="subject">Subject</label>
            <br>
            <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>
            <br>
            <input type="submit" value="Submit" >
        </form>
    
    </body>
</html>
