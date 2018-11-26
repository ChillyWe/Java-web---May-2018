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
        StringBuilder pageContent = new StringBuilder();
        PrintWriter out = resp.getWriter();

        pageContent.append("<h1>All Cats</h1>")
                .append("<hr>");

        Map<String, Cat> cats = (Map<String, Cat>) this.getServletContext().getAttribute("cats");
        for (Cat cat : cats.values()) {
            pageContent.append(String.format("<p><a href=\"/cats/profile?name=%s\">%s</a></p>", cat.getName(), cat.getName()));
        }

        pageContent.append("<hr>")
                .append("<p><a href=\"/\">Back</a></p>\n");
        out.println(pageContent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}