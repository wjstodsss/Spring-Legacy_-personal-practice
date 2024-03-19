package com.blacksmith.ecommerce.admin.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blacksmith.ecommerce.admin.login.domain.MemberDTO;
import com.blacksmith.ecommerce.admin.login.service.LoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class LoginController {
	private final LoginService loginService;
	
	
	@GetMapping("/login")
	public String testForm() {
		return "/admin/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		System.out.println(memberDTO);
		boolean loginResult = loginService.login(memberDTO);
		
		if (loginResult) {
			session.setAttribute("userEmail", memberDTO.getEmail());
			System.out.println(loginResult);
			return "redirect:/admin/secured/index";
		} else {
			return "/admin/login";
		}
	}

	@GetMapping("/secured/index")
	public String securedList() {
		return "/admin/secured/index";
	}

}
