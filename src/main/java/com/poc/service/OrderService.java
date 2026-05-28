package com.poc.service;

import com.poc.entity.Order;
import com.poc.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order create(Order order) {
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }
}
