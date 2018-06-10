package org.softuni.fdmc.data.repos;

import org.softuni.fdmc.data.models.Order;

import java.util.Collections;
import java.util.HashSet;
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

    public Set<Order> takeAllOrdersSorted() {
        return Collections.unmodifiableSet(this.orders.stream()
                .sorted((a, b) -> a.getMadeOn().compareTo(b.getMadeOn()))
                .collect(Collectors.toSet()));
    }
}
