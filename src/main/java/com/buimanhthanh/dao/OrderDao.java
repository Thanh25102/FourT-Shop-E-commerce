package com.buimanhthanh.dao;

import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.OrderDetailDTO;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
	Optional<OrderDTO> getOrderById(Integer id);

	Optional<List<OrderDTO>> getAllOrder();

	Optional<List<OrderDTO>> getOrderByUsername(String username);

	Optional<List<OrderDetailDTO>> getOrderDetailByOrderId(Integer id);

	Boolean saveOrUpdateOrder(Order order);
	
	Boolean saveOrUpdateOrderDetail(OrderDetail orderDetail);
	
	Integer saveOrder(Order order);

	void deleteOrder(Integer id);

	void deleteOrder(List<Integer> ids);
}
