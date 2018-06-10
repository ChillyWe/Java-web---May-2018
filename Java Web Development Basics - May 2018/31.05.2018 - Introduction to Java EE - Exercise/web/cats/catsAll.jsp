<%@ page import="org.softuni.data.Cat" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 06.06.2018 г.
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fluffy Duffy Munchkin Cats</title>
</head>
<body>
    <% Collection<Cat> cats = ((Map<String, Cat>) application.getAttribute("cats")).values(); %>

    <h1>All Cats</h1>
    </hr>
    <% for (Cat cat : cats) { %>
    <h3><a href="/cats/profile?catName=<%=cat.getName()%>"><%=cat.getName()%></a> </h3>
    <% } %>
    <a href="/">Back To Home</a>
</body>
</html>
