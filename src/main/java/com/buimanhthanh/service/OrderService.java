package com.buimanhthanh.service;

import java.util.List;
import java.util.Optional;

import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.OrderDetailDTO;
import com.buimanhthanh.dto.RevenueDTO;

public interface OrderService {
	Optional<OrderDTO> getOrderById(Integer id);

	Optional<List<OrderDTO>> getAllOrder();

	Optional<List<OrderDTO>> getOrderByUsername(String username);

	Optional<List<OrderDetailDTO>> getOrderDetailByOrderId(Integer id);

	Boolean saveOrUpdateOrder(OrderDTO orderDTO);

	Boolean saveOrUpdateOrderDetail(OrderDetailDTO orderDetailDTO);

	Integer saveOrder(OrderDTO orderDTO);

	Boolean checkOut(OrderDTO orderDTO, AccountDTO accountDTO);

	void deleteOrder(Integer id);

	void deleteOrder(List<Integer> ids);

	Double getEarningMonth();

	List<RevenueDTO> getEarningYear();

	List<RevenueDTO> getEarningLastYear();

	Double getEarning();

	List<OrderDTO> getAllOrderPending();

	List<OrderDTO> getAllOrderDelevering();

	List<OrderDTO> getAllOrderComplete();
}
