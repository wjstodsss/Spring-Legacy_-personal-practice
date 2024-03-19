package com.blacksmith.ecommerce.admin.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blacksmith.ecommerce.admin.product.domain.ProductDTO;
import com.blacksmith.ecommerce.admin.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ProductController {
	private final ProductService productService;

	@GetMapping("/secured/product_list")
	public String getProductList(Model model) {
		List<ProductDTO> list = productService.getProductList();
		model.addAttribute("products", list);
		System.out.println("ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ" + model);
		return "admin/secured/product_list";
	}

	@PostMapping("/product_delete")
	public String delete(@RequestParam("id") int id) {
		productService.delete(id);
		return "redirect:/admin/secured/product_list";
	}

	@GetMapping("/secured/product_detail")
	public String read(@RequestParam("id") int id, Model model) {
		ProductDTO productDTO = productService.getOne(id);
		model.addAttribute("product", productDTO);
		System.out.println("asfdfas");
		return "admin/secured/product_detail";
	}

	@PostMapping("/product_update")
	public String update(ProductDTO productDTO, RedirectAttributes redirectAttributes) {

		int result = productService.update(productDTO);
		System.out.println(result);
		if (result > 0) {
			redirectAttributes.addFlashAttribute("msg", "제품 정보가 성공적으로 업데이트되었습니다.");
			return "redirect:/admin/secured/product_list";
		}
		return "admin/secured/product_detail";
	}
}
