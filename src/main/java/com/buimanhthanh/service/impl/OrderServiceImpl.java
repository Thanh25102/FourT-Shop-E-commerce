package com.buimanhthanh.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buimanhthanh.dao.OrderDao;
import com.buimanhthanh.dto.AccountDTO;
import com.buimanhthanh.dto.CartDTO;
import com.buimanhthanh.dto.CartDetailDTO;
import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.OrderDetailDTO;
import com.buimanhthanh.entity.Account;
import com.buimanhthanh.entity.DiscountCode;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.entity.OrderDetail;
import com.buimanhthanh.entity.ProductDetail;
import com.buimanhthanh.enumration.OrderStatus;
import com.buimanhthanh.service.CartService;
import com.buimanhthanh.service.DiscountCodeService;
import com.buimanhthanh.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CartService cartService;
	@Autowired
	private DiscountCodeService discountCodeService;

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
		Order order = new Order(orderDTO.getId(), orderDTO.getOrderStatus(), orderDTO.getAmmount(),
				orderDTO.getPaymentMethod(), orderDTO.getCreateTime(), orderDTO.getPhone(),
				orderDTO.getShipingAddress(), orderDTO.getCity(), null, null, null);
		Account account = new Account();
		account.setUsername(orderDTO.getUsername());
		DiscountCode discountCode = new DiscountCode();
		discountCode.setId(orderDTO.getDiscountCodeId());
		order.setDiscountCodeByDiscountCodeId(discountCode);
		order.setAccountByUsername(account);
		java.util.Date today = new java.util.Date();
		java.sql.Date date = new java.sql.Date(today.getTime()); // your SQL date object
		order.setCreateTime(date);

		return orderDao.saveOrUpdateOrder(order);
	}

	@Override
	@Transactional
	public Integer saveOrder(OrderDTO orderDTO) {
		Order order = new Order(orderDTO.getId(), orderDTO.getOrderStatus(), orderDTO.getAmmount(),
				orderDTO.getPaymentMethod(), orderDTO.getCreateTime(), orderDTO.getPhone(),
				orderDTO.getShipingAddress(), orderDTO.getCity(), null, null, null);
		
		Account account = new Account();
		account.setUsername(orderDTO.getUsername());
		if(orderDTO.getDiscountCodeId() !=null) {
			DiscountCode discountCode = new DiscountCode();
			discountCode.setId(orderDTO.getDiscountCodeId());
			order.setDiscountCodeByDiscountCodeId(discountCode);
		}else {
			order.setDiscountCodeByDiscountCodeId(null);
		}
		
		order.setAccountByUsername(account);
		java.util.Date today = new java.util.Date();
		java.sql.Date date = new java.sql.Date(today.getTime()); // your SQL date object
		order.setCreateTime(date);
		System.out.println(order.toString());
		return orderDao.saveOrder(order);
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

	@Override
	@Transactional
	public Optional<List<OrderDetailDTO>> getOrderDetailByOrderId(Integer id) {
		return orderDao.getOrderDetailByOrderId(id);
	}

	@Override
	@Transactional
	public Boolean checkOut(OrderDTO orderDTO, AccountDTO accountDTO) {
		CartDTO cartDTO = cartService.getCartByUsername(accountDTO.getUsername()).get();
		List<CartDetailDTO> cartDetailDTOs = cartService.getCartDetailByCart(cartDTO.getId()).get();
		List<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();

		orderDTO.setUsername(accountDTO.getUsername());
		orderDTO.setOrderStatus(OrderStatus.PENDING.getValue());
		orderDTO.setAmmount(cartDTO.getAmmount());

		discountCodeService.getDiscountCodeByCode(orderDTO.getDiscountCode()).ifPresentOrElse(
				code -> orderDTO.setDiscountCodeId(code.getId()), () -> orderDTO.setDiscountCodeId(null));

		Integer id = saveOrder(orderDTO);
		OrderDTO orderTemp = getOrderById(id).get();
		cartDetailDTOs.forEach(cartDetail -> orderDetailDTOs.add(new OrderDetailDTO(null, cartDetail.getProductId(), id,
				cartDetail.getPrice(), cartDetail.getQuantity())));
		orderDetailDTOs.forEach(o -> {
			saveOrUpdateOrderDetail(o);
		});

		return true;
	}

	@Override
	@Transactional
	public Boolean saveOrUpdateOrderDetail(OrderDetailDTO orderDetailDTO) {
		OrderDetail orderDetail = new OrderDetail(null, orderDetailDTO.getPrice(), orderDetailDTO.getQuantity(), null,
				null);
		ProductDetail productDetail = new ProductDetail();
		productDetail.setId(orderDetailDTO.getProductId());
		Order order = new Order();
		order.setId(orderDetailDTO.getOrderId());

		orderDetail.setProductDetailByProductId(productDetail);
		orderDetail.setOrderByOrderId(order);

		return orderDao.saveOrUpdateOrderDetail(orderDetail);
	}
}
