package com.buimanhthanh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private Integer id;
    @NotNull(message = "{null.err}")
    private Integer productId;
    @NotNull(message = "{null.err}")
    private Integer sizeId;
    @NotNull(message = "{null.err}")
    private Integer colorId;
    @NotNull(message = "{null.err}")
    private Integer quantity;
    @Length(max = 255, message = "{access.description.err}")
    @NotNull(message = "{null.err}")
    private String description;
    @Length(max = 255, message = "{access.description.err}")
    private String image;
}
