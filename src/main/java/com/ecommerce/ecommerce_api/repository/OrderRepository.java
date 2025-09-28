package com.ecommerce.ecommerce_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce_api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    boolean existsByOrderId(String orderId);

    Order findByOrderId(String orderId);
}
