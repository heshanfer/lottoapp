<%-- 
    Document   : retrieveresults
    Created on : Dec 3, 2016, 1:37:42 AM
    Author     : Heshan
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h1>Retrieve Results</h1>
    <%
        String r =request.getParameter("uname");
        System.out.print(r);
        Date d1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
        String formattedDate = df.format(d1);
        System.out.print(formattedDate);
        
        System.out.print("dddddddddddddd");
        
    %>
</html>
