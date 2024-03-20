package com.blacksmith.ecommerce.admin.product.repository;

import java.util.List;

import com.blacksmith.ecommerce.admin.product.domain.ProductDTO;

public interface ProductRepository {
	List<ProductDTO> getProductList();
	void delete(int id);
	ProductDTO getOne(int id);
	int update(ProductDTO productDTO);
	int insert(ProductDTO productDTO);
}
