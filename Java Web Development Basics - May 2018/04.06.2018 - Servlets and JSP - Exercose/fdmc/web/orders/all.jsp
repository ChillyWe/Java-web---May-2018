<%@ page import="org.softuni.fdmc.data.models.Order" %>
<%@ page import="org.softuni.fdmc.data.repos.OrderRepository" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10.06.2018 г.
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
        <h1>All Orders</h1>
        <hr />
        <% response.setIntHeader("Refresh", 3);

            Set<Order> orders = ((OrderRepository) application.getAttribute("orders")).takeAllOrdersSorted();

            for(Order order : orders) { %>
            <hr />
                 <h3>Client name: <%= order.getClient().getUsername()%></h3>
                 <h3>Cat name: <%= order.getCat().getName()%></h3>
        <% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY  HH:MM:SS"); %>
                 <h3>Date: <%= formatter.format(order.getMadeOn())%></h3>
            <hr />
        <% } %>
        <br />
        <a href="/">Back to Home</a>
</body>
</html>
