<%@ page import="org.softuni.fdmc.data.models.Order" %>
<%@ page import="org.softuni.fdmc.data.repos.OrderRepository" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Set" %>
<%--
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
        <%! private static final String CUSTOM_DATE_TIME_FORMAT = "dd/MM/YYYY  HH:mm:ss";%>
        <% Set<Order> orders = ((OrderRepository) application.getAttribute("orders")).takeAllOrdersSorted();

        if (orders.size() > 0) {
            for(Order order : orders) { %>
            <hr />
                <h3>Client name: <%= order.getClient().getUsername()%></h3>
                <h3>Cat name: <%= order.getCat().getName()%></h3>
                <% DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CUSTOM_DATE_TIME_FORMAT); %>
                <h3>Date: <%= formatter.format(order.getMadeOn())%></h3>
            <hr />
        <% }
        } else {
            out.println("There are no placed orders. <br/>");
        }%>
        <br />
        <a href="/">Back to Home</a>
</body>
</html>