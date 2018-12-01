package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {

    private List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public List<Order> getAllOrders() {
        List<Order> sortedOrders = this.orders.stream()
                .sorted((a,b) -> b.getMadeOn().compareTo(a.getMadeOn()))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(sortedOrders);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
