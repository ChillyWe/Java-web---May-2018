package org.softuni.servlets;

import org.softuni.data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        this.getServletContext().setAttribute("cats", new HashMap<String, Cat>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println("<h1> Welcome to Fluffy Duffy Munchkin Cats!</h1>");
        out.println("<h3> Navigate through the application using links below!</h3>");
        out.println("<hr>");
        out.println("<p><a href=\"/cats/create\">Create Cat</a></p>");
        out.println("<p><a href=\"/cats/all\">All Cats</a></p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}