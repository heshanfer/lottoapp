<%-- 
    Document   : Login
    Created on : Nov 29, 2016, 11:29:39 PM
    Author     : Heshan
--%>

<%@page import="controllers.UserController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lotto App</title>
    </head>
    <body>
        
        <% 
            String userName = request.getParameter("uname");    
            String pwd = request.getParameter("pass");
    
             boolean result = UserController.checkPassword(userName, pwd);
             if(result){
                 System.out.println("Valid");
                 response.sendRedirect("dashboard.jsp");
             }else{
                 System.out.println("Invalid");   
             }
        %>
        

    </body>
</html>
