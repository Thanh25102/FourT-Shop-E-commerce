package com.buimanhthanh.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable{
	private Integer id;
	@NotNull(message = "{null.err}")
	@Length(max = 55, message = "{access.code.err}")
	private String name;
	@NotNull(message = "{null.err}")
	private Double price;
	@NotNull(message = "{null.err}")
	private Integer categoryId;
	@Length(max = 255, message = "{access.description.err}")
	private String description;
	@Length(max = 55, message = "{access.code.err}")
	private String thumbnail;
	@Length(max = 255, message = "{access.description.err}")
	private String represent;
	private Integer discountId;
	private Integer salePercent;

	private Double priceNew;

	public Double getPriceNew() {
		return salePercent == null ? price : price - (price * (salePercent * 0.01));
	}

	public ProductDTO(Integer id,
			@NotNull(message = "{null.err}") @Length(max = 55, message = "{access.code.err}") String name,
			@NotNull(message = "{null.err}") Double price, @NotNull(message = "{null.err}") Integer categoryId,
			@Length(max = 255, message = "{access.description.err}") String description,
			@Length(max = 55, message = "{access.code.err}") String thumbnail,
			@Length(max = 255, message = "{access.description.err}") String represent, Integer discountId) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.description = description;
		this.thumbnail = thumbnail;
		this.represent = represent;
		this.discountId = discountId;
	}

	public ProductDTO(Integer id,
			@NotNull(message = "{null.err}") @Length(max = 55, message = "{access.code.err}") String name,
			@NotNull(message = "{null.err}") Double price, @NotNull(message = "{null.err}") Integer categoryId,
			@Length(max = 255, message = "{access.description.err}") String description,
			@Length(max = 55, message = "{access.code.err}") String thumbnail,
			@Length(max = 255, message = "{access.description.err}") String represent, Integer discountId,
			Integer salePercent) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.description = description;
		this.thumbnail = thumbnail;
		this.represent = represent;
		this.discountId = discountId;
		this.salePercent = salePercent;
	}

	private MultipartFile file;

}
