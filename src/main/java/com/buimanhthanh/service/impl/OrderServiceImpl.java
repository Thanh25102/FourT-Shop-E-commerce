package com.buimanhthanh.service.impl;

import com.buimanhthanh.dao.OrderDao;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public Optional<Order> getOrderById(Integer id) {
        return orderDao.getOrderById(id);
    }

    @Override
    @Transactional
    public Optional<List<Order>> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    @Transactional
    public Boolean saveOrUpdateOrder(Order order) {
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
}
