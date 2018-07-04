package org.softuni.servlets;

import org.softuni.repos.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/all")
public class ProductAllServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        this.getServletContext().setAttribute("products", new ProductRepository());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("all.jsp").forward(req, resp);
    }
}