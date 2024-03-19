package com.blacksmith.ecommerce.admin.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blacksmith.ecommerce.admin.product.domain.ProductDTO;
import com.blacksmith.ecommerce.admin.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
	private final ProductRepository productRepository;
	
	@Override
	public List<ProductDTO> getProductList(){
		return productRepository.getProductList();
	}
	
	@Override
	public void delete(int id) {
		productRepository.delete(id);
	}
	
	@Override
	public ProductDTO getOne(int id){
		return productRepository.getOne(id);
	}
	
	@Override
	public int update(ProductDTO productDTO){
		return productRepository.update(productDTO);
	}
	
	
}
