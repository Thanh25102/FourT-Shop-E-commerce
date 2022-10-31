package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.OrderDTO;

public interface OrderService {
    Optional<OrderDTO> getOrderById(Integer id);

    Optional<List<OrderDTO>> getAllOrder();

    Boolean saveOrUpdateOrder(OrderDTO orderDTO);

    void deleteOrder(Integer id);

    void deleteOrder(List<Integer> ids);
}
