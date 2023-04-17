package com.maven.repository;

import com.maven.entity.Order;

public interface OrderRepository {
    Order createOrder(Long id);
    Order getOrCreateOrder(Long id);
}
