package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Order;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderRepository {
    private Set<Order> orders;

    public OrderRepository() {
        this.orders = new HashSet<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> takeAllOrdersSorted() {
        return Collections.unmodifiableList(this.orders.stream()
                .sorted((a, b) -> b.getMadeOn().compareTo(a.getMadeOn()))
                .collect(Collectors.toList()));
    }
}