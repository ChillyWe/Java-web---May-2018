package org.softuni.fdmc.servlets.orders;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.Order;
import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.OrderRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/orders/create")
public class CreateOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository userRepository = (UserRepository)(this.getServletContext().getAttribute("users"));
        CatRepository catRepository = (CatRepository)(this.getServletContext().getAttribute("cats"));
        User user = userRepository.getByUsername(req.getSession().getAttribute("username").toString());
        String debug = req.getParameter("catName");
        Cat cat = catRepository.getByName(debug);
        Order order = new Order(user, cat, LocalDateTime.now());

        ((OrderRepository)this.getServletContext().getAttribute("orders")).addOrder(order);

        resp.sendRedirect("/");
    }
}