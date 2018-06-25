<%@ page import="org.softuni.examPrep.models.Tube" %>
<%@ page import="java.util.List" %>
<%@ page import="org.softuni.examPrep.repos.TubeRepository" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 21.06.2018 г.
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Tubes JSP</title>
</head>
<body>
    <h1>All Tubes</h1>
    <hr/>
        <%
            List<Tube> tubes = ((TubeRepository) application.getAttribute("tubes")).getAllTubes();
            if (tubes.size() > 0) {
                for (Tube tube : tubes) {
                    String debug = ("<h3> <a href=\"/cats/profile?catName=" + cat.getName() + "\">" + cat.getName() + "</a></h3>\n");
                    out.println(debug);
                }
            } else {
                out.println("There are no placed tubes. <br/>");
            }%>

</body>
</html>
