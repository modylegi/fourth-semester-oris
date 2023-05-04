package com.example.demo.services;

import com.example.demo.dto.OrderDto;
import com.example.demo.entities.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders();

    OrderDto createOrder(Order order);

    void deleteOrder(Long orderId);

    OrderDto updateOrder(Long productId, String name, String description, int price);
}
