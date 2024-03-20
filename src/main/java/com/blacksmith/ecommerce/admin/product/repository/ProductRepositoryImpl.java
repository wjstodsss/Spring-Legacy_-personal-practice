package com.blacksmith.ecommerce.admin.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.blacksmith.ecommerce.admin.product.domain.ProductDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ProductDTO> getProductList(){
		return sqlSessionTemplate.selectList("mapper.productMapper.getProductList");
	}
	
	@Override
	public void delete(int id) {
		sqlSessionTemplate.delete("mapper.productMapper.delete", id);
	}
	
	@Override
	public ProductDTO getOne(int id){
		return sqlSessionTemplate.selectOne("mapper.productMapper.getOne", id);
	}
	
	@Override
	public int update(ProductDTO productDTO){
		return sqlSessionTemplate.update("mapper.productMapper.update", productDTO);
	}
	
	@Override
	public int insert(ProductDTO productDTO) {
		return sqlSessionTemplate.insert("mapper.productMapper.insert", productDTO);
	}
	
}
