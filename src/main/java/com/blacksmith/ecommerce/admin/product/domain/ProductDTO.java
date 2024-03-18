package com.blacksmith.ecommerce.admin.product.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private int id;
    private String name;
    private String description;
    private int price;
    private int category;
    private String imageUrl;
}
