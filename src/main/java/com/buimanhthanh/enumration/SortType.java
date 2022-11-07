package com.buimanhthanh.enumration;

import lombok.Getter;

public enum SortType {
	ASC("ASC"), DESC("DESC");

	@Getter
	private final String value;

	private SortType(String value) {
		this.value = value;
	}
}
