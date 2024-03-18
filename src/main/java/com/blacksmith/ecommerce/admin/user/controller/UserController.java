package com.blacksmith.ecommerce.admin.user.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;
import com.blacksmith.ecommerce.admin.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/secured/user_list")
	public String getUserList(Model model) {
		List<UserDTO> list = userService.getUserList();
		System.out.println(list);
		model.addAttribute("users", list);
		System.out.println(model);
		return "admin/secured/user_list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
	    userService.delete(id);
	    redirectAttributes.addFlashAttribute("msg", "사용자 계정이 성공적으로 삭제되었습니다.");
	    return "redirect:/admin/secured/user_list";
	}
	
	@GetMapping("/secured/detail")
	public String read(@RequestParam("id") int id, Model model) {
	    UserDTO userDTO = userService.getOne(id);
	    model.addAttribute("user", userDTO);
	    return "admin/secured/detail";
	}
	
	@PostMapping("/update")
	public String update(UserDTO userDTO, RedirectAttributes redirectAttributes) {
		System.out.println(userDTO + "pp");
	    int result = userService.update(userDTO);
	    if (result > 0) {
	        redirectAttributes.addFlashAttribute("msg", "사용자 정보가 성공적으로 업데이트되었습니다.");
	        return "redirect:/admin/secured/user_list";
	    }
	    // 업데이트에 실패한 경우에는 해당 사용자의 상세 정보 페이지로 다시 이동
	    return "admin/secured/detail";
	}
	
}
