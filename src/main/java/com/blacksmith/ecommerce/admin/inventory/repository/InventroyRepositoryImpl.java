package com.blacksmith.ecommerce.admin.inventory.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.blacksmith.ecommerce.admin.inventory.domain.InventoryDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InventroyRepositoryImpl implements InventroyRepository {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<InventoryDTO> getInventoryList(){
		return sqlSessionTemplate.selectList("mapper.inventoryMapper.getInventoryList");
	};
	
	@Override
	public void delete(int id) {
		sqlSessionTemplate.delete("mapper.inventoryMapper.delete", id);
	};
	
	@Override
	public InventoryDTO getOne(int id){
		return sqlSessionTemplate.selectOne("mapper.inventoryMapper.getOne", id);
	}
	
	@Override
	public int update(InventoryDTO inventoryDTO){
		return sqlSessionTemplate.update("mapper.inventoryMapper.update", inventoryDTO);
	}
	
	@Override
	public int insert(InventoryDTO inventoryDTO) {
		return sqlSessionTemplate.insert("mapper.inventoryMapper.insert", inventoryDTO);
	}

}
