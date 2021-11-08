<%-- 
    Document   : add_result
    Created on : Nov 8, 2021, 12:33:40 PM
    Author     : Theerakan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Result</title>
    </head>
     <body>
         <h1><%=request.getAttribute("rowInserted") + " row is added " %> </h1>
        </br>
        <jsp:include page="show_student.jsp" flush="true" />
    </body>
</html>
