package com.buimanhthanh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.OrderDao;
import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.DiscountCode;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public Optional<OrderDTO> getOrderById(Integer id) {
        return orderDao.getOrderById(id);
    }

    @Override
    @Transactional
    public Optional<List<OrderDTO>> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateOrder(OrderDTO orderDTO) {
    	Order order = new Order(orderDTO.getId(),orderDTO.getOrderStatus(),orderDTO.getAmmount(),orderDTO.getPaymentMethod(),orderDTO.getCreateTime(),null,null,null);
    	Account account = new Account();
    	account.setUsername(orderDTO.getUsername());
    	DiscountCode discountCode = new DiscountCode();
    	discountCode.setId(orderDTO.getDiscountCodeId());
    	order.setDiscountCodeByDiscountCodeId(discountCode);
    	order.setAccountByUsername(account);
    	
        return orderDao.saveOrUpdateOrder(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Integer id) {
        orderDao.deleteOrder(id);
    }

    @Override
    @Transactional
    public void deleteOrder(List<Integer> ids) {
        orderDao.deleteOrder(ids);
    }

	@Override
	@Transactional
	public Optional<List<OrderDTO>> getOrderByUsername(String username) {
		return orderDao.getOrderByUsername(username);
	}
}
