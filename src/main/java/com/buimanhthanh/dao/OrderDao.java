package com.buimanhthanh.dao;

import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.OrderDetailDTO;
import com.buimanhthanh.dto.RevenueDTO;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.entity.OrderDetail;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface OrderDao {
	Optional<OrderDTO> getOrderById(Integer id);

	Optional<List<OrderDTO>> getAllOrder();

	Optional<List<OrderDTO>> getOrderByUsername(String username);

	Optional<List<OrderDTO>> getAllOrderPending();

	Optional<List<OrderDTO>> getAllOrderDelevering();

	Optional<List<OrderDTO>> getAllOrderComplete();

	Optional<List<OrderDetailDTO>> getOrderDetailByOrderId(Integer id);

	Optional<List<OrderDetailDTO>> getAllOrderDetailComplete();

	Optional<List<OrderDetailDTO>> getAllOrderDetailComplete(Month month);

	Boolean saveOrUpdateOrder(Order order);

	Boolean saveOrUpdateOrderDetail(OrderDetail orderDetail);

	Integer saveOrder(Order order);

	void deleteOrder(Integer id);

	void deleteOrder(List<Integer> ids);

	Optional<List<RevenueDTO>> getEarningYear(int year);
}
