<%-- 
    Document   : confirm_remove
    Created on : Nov 8, 2021, 1:05:14 PM
    Author     : Theerakan
--%>

<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Remove Student</title>
    </head>
    <body>
       <%
            Student std = (Student) getServletContext().getAttribute("student");
            
        %>
        <form name="confirmRemove" action="ConfirmRemoveController">
            ID: <%= std.getId() %> </br>
            Name: <%= std.getName() %> </br>
            Gpa <%= std.getGpa() %> </br>
            <input type="submit" value="Delete" name="delete" />
            <input type="submit" value="Cancel" name="cancel" />
            
        </form>
    </body>
</html>
