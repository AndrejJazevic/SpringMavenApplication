package com.maven.repository;

import com.maven.entity.Order;

public interface OrderRepository {
    Order createOrder(Long id);
    Order getOrCreateOrder(Long id);
    Order findOrderById(Long id);
    Order updateOrderCustomerById(Long orderId, Long customerId);
    Order deleteOrderById(Long id);
}
