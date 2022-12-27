package com.buimanhthanh.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	//start date of discount if it's != null
	private Date startDate;
	//end date of discount if it's != null
	private Date endDate;
	private Double priceNew;

	public Double getPriceNew() {
		if (startDate != null && endDate != null) {
			LocalDate currentDate = LocalDate.now();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
			LocalDate startDateWithoutTime = LocalDate.parse(startDate.toString(), formatter);
			LocalDate endDateWithoutTime = LocalDate.parse(endDate.toString(), formatter);

			if (currentDate.compareTo(startDateWithoutTime) >= 0 && currentDate.compareTo(endDateWithoutTime) <= 0) {
				return price - (price * (salePercent * 0.01));
			}
		}
		return null;
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

	public ProductDTO(Integer id,
			@NotNull(message = "{null.err}") @Length(max = 55, message = "{access.code.err}") String name,
			@NotNull(message = "{null.err}") Double price, @NotNull(message = "{null.err}") Integer categoryId,
			@Length(max = 255, message = "{access.description.err}") String description,
			@Length(max = 55, message = "{access.code.err}") String thumbnail,
			@Length(max = 255, message = "{access.description.err}") String represent, Integer discountId,
			Integer salePercent, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.description = description;
		this.thumbnail = thumbnail;
		this.represent = represent;
		this.discountId = discountId;
		this.salePercent = salePercent;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private MultipartFile file;

}
