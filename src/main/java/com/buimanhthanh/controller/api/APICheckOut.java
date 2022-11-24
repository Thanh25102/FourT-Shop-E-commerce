package com.buimanhthanh.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.dto.ResponeObject;
import com.buimanhthanh.service.OrderService;

@RestController
@RequestMapping("/api/v1/checkout")
public class APICheckOut {

	@Autowired
	private OrderService orderService;

	@PostMapping("")
	public ResponseEntity<ResponeObject> checkOut(@RequestBody OrderDTO orderDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponeObject("ok", "Insert orderDTO successfully", orderService.saveOrUpdateOrder(orderDTO)));
	}
	
	
}
