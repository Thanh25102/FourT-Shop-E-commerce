package com.buimanhthanh.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDetailDTO {
	private Integer id;
	private Integer productId;
	private Integer cartId;
	private Double price;
	private Integer quantity;

	private String productName;
	private String productImage;
	private Integer productSalePersent;

	private Double priceNew;
	private Double productPrice;

	private Date startDate;
	private Date endDate;

	public CartDetailDTO(Integer id, Integer productId, Integer cartId, Double price, Integer quantity) {
		this.id = id;
		this.productId = productId;
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
	}

	public CartDetailDTO(Integer id, Integer productId, Integer cartId, Double price, Integer quantity,
			String productName, String productImage) {
		this.id = id;
		this.productId = productId;
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.productName = productName;
		this.productImage = productImage;
	}

	public CartDetailDTO(Integer id, Integer productId, Integer cartId, Double price, Integer quantity,
			String productName, String productImage, Integer productSalePersent) {
		this.id = id;
		this.productId = productId;
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.productName = productName;
		this.productImage = productImage;
		this.productSalePersent = productSalePersent;
	}

	public Double getPriceNew() {
		if (startDate != null && endDate != null) {
			LocalDate currentDate = LocalDate.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate startDateWithoutTime = LocalDate.parse(startDate.toString(), formatter);
			LocalDate endDateWithoutTime = LocalDate.parse(endDate.toString(), formatter);

			if (currentDate.compareTo(startDateWithoutTime) >= 0 && currentDate.compareTo(endDateWithoutTime) <= 0) {
				return productPrice - (productPrice * (productSalePersent * 0.01));
			}
		}
		return productPrice;
	}
	
	public CartDetailDTO(Integer id, Integer productId, Integer cartId, Double price, Integer quantity,
			String productName, String productImage, Integer productSalePersent, Double productPrice) {
		this.id = id;
		this.productId = productId;
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.productName = productName;
		this.productImage = productImage;
		this.productSalePersent = productSalePersent;
		this.productPrice = productPrice;
	}

	public CartDetailDTO(Integer id, Integer productId, Integer cartId, Double price, Integer quantity,
			String productName, String productImage, Integer productSalePersent, Double productPrice, Date startDate,
			Date endDate) {
		this.id = id;
		this.productId = productId;
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.productName = productName;
		this.productImage = productImage;
		this.productSalePersent = productSalePersent;
		this.productPrice = productPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}

}
