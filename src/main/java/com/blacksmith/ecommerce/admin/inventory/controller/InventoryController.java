package com.blacksmith.ecommerce.admin.inventory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blacksmith.ecommerce.admin.inventory.domain.InventoryDTO;
import com.blacksmith.ecommerce.admin.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class InventoryController {
	private final InventoryService inventoryService;

	@GetMapping("/secured/inventory_list")
	public String getInventoryList(Model model) {
		List<InventoryDTO> list = inventoryService.getInventoryList();

		model.addAttribute("inventories", list);

		System.out.println(model);
		return "admin/secured/inventory_list";
	}

	@PostMapping("/inventory_delete")
	public String delete(@RequestParam("id") int id) {
		inventoryService.delete(id);
		return "redirect:/admin/secured/inventory_list";
	}

	@GetMapping("/secured/inventory_detail")
	public String read(@RequestParam("id") int id, Model model) {
		InventoryDTO inventoryDTO = inventoryService.getOne(id);
		model.addAttribute("inventory", inventoryDTO);
		System.out.println("asfdfas");
		return "admin/secured/inventory_detail";
	}

	@PostMapping("/inventory_update")
	public String update(InventoryDTO inventoryDTO, RedirectAttributes redirectAttributes) {

		int result = inventoryService.update(inventoryDTO);
		System.out.println(result);
		if (result > 0) {
			redirectAttributes.addFlashAttribute("msg", "재고 정보가 성공적으로 업데이트되었습니다.");
			return "redirect:/admin/secured/inventory_list";
		}
		return "admin/secured/inventory_detail";
	}

	@GetMapping("/inventory_add")
	public String insert() {
		return "admin/secured/inventory_add";
	}

	@PostMapping("/inventory_insert")
	public String insert(InventoryDTO inventoryDTO, Model model) {
		int result = inventoryService.insert(inventoryDTO);
		
		if (result < 0) {
			System.out.println("제품 등록 실패");
		}
		return "redirect: secured/inventory_list";
	}

}