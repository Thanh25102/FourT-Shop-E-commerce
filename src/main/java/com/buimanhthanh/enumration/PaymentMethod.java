package com.buimanhthanh.enumration;

import lombok.Getter;

public enum PaymentMethod {
	MOMO("Momo"),CREDITCARDS("Credit Cards"),MOBILEPAYMENTS("Mobile Payments"),CASH("Cash");

	@Getter
	private final String value;

	private PaymentMethod(String value) {
		this.value = value;
	}
}
