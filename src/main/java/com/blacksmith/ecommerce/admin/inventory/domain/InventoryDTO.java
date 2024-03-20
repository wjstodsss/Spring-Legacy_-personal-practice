package com.blacksmith.ecommerce.admin.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {
    private int id;
    private String productName;
    private int stockQuantity;
    private int salesQuantity;
    private int orderedQuantity;
    private String remarks;
}