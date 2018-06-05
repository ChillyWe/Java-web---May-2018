package org.softuni.servlets;

import org.softuni.data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cats/all")
public class CatsAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        StringBuilder pageContent = new StringBuilder();

        Map<String, Cat> cats = (Map<String, Cat>) getServletContext().getAttribute("cats");

        pageContent.append("<html>\n")
                .append("<h1>All Cats</h1>\n")
                .append("<hr/>").append("\n\r");


        if (cats == null) {
                pageContent.append("<h2>There are no cats.")
                        .append("<a href=\"<c:url value=\"/cats/create\"/\">Create some!</a></h2>");
        } else {
            for (Cat cat : cats.values()) {
                pageContent.append("<h3><a href=\"<c:url value=\"/cats/profile?catName=" + cat.getName() +"\"/\">" + cat.getName() +"</a></h3>\n\r");
            }
        }

        pageContent.append("<a href=\"<c:url value=\"/\"/\">Back To Home</a>");

        out.println(pageContent.toString());
    }
}