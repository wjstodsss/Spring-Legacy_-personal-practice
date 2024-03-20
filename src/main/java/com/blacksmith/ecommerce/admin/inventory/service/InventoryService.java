package com.blacksmith.ecommerce.admin.inventory.service;

import java.util.List;

import com.blacksmith.ecommerce.admin.inventory.domain.InventoryDTO;

public interface InventoryService {

	List<InventoryDTO> getInventoryList();

	void delete(int id);

	InventoryDTO getOne(int id);

	int update(InventoryDTO inventoryDTO);

	int insert(InventoryDTO inventoryDTO);

}
