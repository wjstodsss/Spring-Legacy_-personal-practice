package com.blacksmith.ecommerce.admin.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blacksmith.ecommerce.admin.inventory.domain.InventoryDTO;
import com.blacksmith.ecommerce.admin.inventory.repository.InventroyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
	private final InventroyRepository inventoryRepository;
	
	@Override
	public List<InventoryDTO> getInventoryList(){
		return inventoryRepository.getInventoryList();
	};
	
	@Override
	public void delete(int id) {
		inventoryRepository.delete(id);
	};

	@Override
	public InventoryDTO getOne(int id){
		return inventoryRepository.getOne(id);
	};
	
	@Override
	public int update(InventoryDTO inventoryDTO){
		return inventoryRepository.update(inventoryDTO);
	}
	
	@Override
	public int insert(InventoryDTO inventoryDTO) {
		return inventoryRepository.insert(inventoryDTO);
	}
	
}
