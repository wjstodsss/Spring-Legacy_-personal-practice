package com.blacksmith.ecommerce.admin.product.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blacksmith.ecommerce.admin.product.domain.ProductDTO;
import com.blacksmith.ecommerce.admin.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ProductController {
	@Autowired
	private ServletContext servletContext; // ServletContext 주입

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
		if (result > 0) {
			redirectAttributes.addFlashAttribute("msg", "제품 정보가 성공적으로 업데이트되었습니다.");
			return "redirect:/admin/secured/product_list";
		}
		return "admin/secured/product_detail";
	}
	
	@GetMapping("/upload_form")
	public String uploadForm() {
		return "admin/secured/product_add";
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("uploadFiles") MultipartFile[] files, Model model, ProductDTO productDTO) {
		System.out.println(productDTO);
		// 파일 저장 경로 설정
		String uploadPath = servletContext.getRealPath("/admin/secured/upload");

		// 업로드 디렉토리 생성
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		try {
			// 파일 저장
			List<String> fileNames = new ArrayList<>();
			for (MultipartFile file : files) {
				String fileName = file.getOriginalFilename();
				File dest = new File(uploadDir.getAbsolutePath() + File.separator + fileName);
				System.out.println(dest);
				file.transferTo(dest);
				fileNames.add(fileName);
			}
			
			int result = productService.insert(productDTO);
			
			if (result < 0) {
				throw new IOException("제품 등록 실패");
			}
			// 모델에 파일명 추가
			model.addAttribute("fileNames", fileNames);

			// 성공 페이지로 이동
			return "admin/secured/success";
		} catch (IOException e) {
			e.printStackTrace();
			// 실패 페이지로 이동
			return "error";
		}

	}

	@GetMapping("/secured/upload/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
		// 파일 경로 설정
		String uploadDirectory = servletContext.getRealPath("/admin/secured/upload");
		Path filePath = Paths.get(uploadDirectory).resolve(fileName).normalize();
		Resource resource;
		try {
			resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + resource.getFilename() + "\"")
						.body(resource);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.notFound().build();
	}
}
