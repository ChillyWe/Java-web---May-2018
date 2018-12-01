<%@ page import="org.softuni.fdmc.data.models.Order" %>
<%@ page import="org.softuni.fdmc.data.repos.OrderRepository" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 01.12.2018 г.
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>

<% OrderRepository orders = ((OrderRepository) application.getAttribute("orders")); %>
<% List<Order> orderList = orders.getAllOrders();%>
<% for (Order order : orderList) {%>
<hr/>
<h3> Client Name: <%= order.getClient().getUsername()%></h3>
<h3> Cat Name: <%= order.getCat().getName()%></h3>
<h3> Made on : <%= order.getMadeOn()%></h3>
<hr/>
<% }%>
<br />
<a href="/">Back</a>
</body>
</html>