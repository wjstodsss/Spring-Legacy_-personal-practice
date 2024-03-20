package com.blacksmith.ecommerce.admin.inventory.repository;

import java.util.List;

import com.blacksmith.ecommerce.admin.inventory.domain.InventoryDTO;

public interface InventroyRepository {
	List<InventoryDTO> getInventoryList();

	void delete(int id);

	InventoryDTO getOne(int id);

	int update(InventoryDTO inventoryDTO);

	int insert(InventoryDTO inventoryDTO);

}
