package com.blacksmith.ecommerce.admin.product.service;

import java.util.List;

import com.blacksmith.ecommerce.admin.product.domain.ProductDTO;

public interface ProductService {
	List<ProductDTO> getProductList();
	void delete(int id);
	ProductDTO getOne(int id);
	int update(ProductDTO productDTO);
}
