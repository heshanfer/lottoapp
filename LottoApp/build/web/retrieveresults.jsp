<%-- 
    Document   : retrieveresults
    Created on : Dec 3, 2016, 1:37:42 AM
    Author     : Heshan
--%>

<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h1>Retrieve Results</h1>
    <%
        URL oracle = new URL("http://www.nlb.lk/show-results.php?lott=5&date=16-11-23");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
        //    System.out.println(inputLine);
            %>
                <h1><%=inputLine%></h1>
            <%
        }
        in.close();
    
    %>
</html>
