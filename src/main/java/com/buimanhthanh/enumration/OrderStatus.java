package com.buimanhthanh.enumration;

import lombok.Getter;

public enum OrderStatus {
	PENDING("PENDING"), DELIVERED("DELIVERED"), DELIVERING("DELIVERING");

	@Getter
	private final String value;

	private OrderStatus(String value) {
		this.value = value;
	}
}
