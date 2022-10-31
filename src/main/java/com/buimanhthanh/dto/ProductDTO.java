package com.buimanhthanh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
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
}
