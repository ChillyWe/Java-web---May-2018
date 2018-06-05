package org.softuni.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        StringBuilder sb = new StringBuilder();


        sb.append("<h1> Welcome to Fluffy Duffy Munchkin Cats </h1>").append("\n\r")
                .append("<h3> Navigate through the application using links below! </h3>").append("\n\r")
                .append(" <hr/>").append("\n\r")
                .append("<div class=\"mt-5\">").append("\n\r")
                .append("<a href=\"/cats/create\"\">Create cat</a>\n")
                .append("</div>").append("\n\r")
                .append("<div >").append("\n\r")
                .append("<a href = \"/cats/all\"\">All cats</a>").append("\n\r")
                .append("</div>").append("\n\r");

        out.println(sb.toString());
    }
}