package com.buimanhthanh.dao;

import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
	Optional<OrderDTO> getOrderById(Integer id);

	Optional<List<OrderDTO>> getAllOrder();

	Optional<List<OrderDTO>> getOrderByUsername(String username);

	Boolean saveOrUpdateOrder(Order order);

	void deleteOrder(Integer id);

	void deleteOrder(List<Integer> ids);
}
