package com.buimanhthanh.service;

import com.buimanhthanh.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> getOrderById(Integer id);

    Optional<List<Order>> getAllOrder();

    Boolean saveOrUpdateOrder(Order order);

    void deleteOrder(Integer id);

    void deleteOrder(List<Integer> ids);
}
