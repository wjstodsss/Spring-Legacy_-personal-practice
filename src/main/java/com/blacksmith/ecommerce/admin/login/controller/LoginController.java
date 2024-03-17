package com.blacksmith.ecommerce.admin.login.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/*
 	public class MemberDTO {
	    private Long id;
	    private String username;
	    private String password;
	    private String email;
	    private LocalDateTime createdAt;
	}
	*/
	@GetMapping("/login")
	public String loginForm() {
		return "/admin/login";
	}
	
	@PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO,
                        HttpSession session) {
		
        boolean loginResult = loginService.login(memberDTO);
        
        if (loginResult) {
            session.setAttribute("email", memberDTO.getEmail());
            System.out.println(session.getAttribute("email"));
            return "redirect:/admin/secured/index";
        } else {
            return "/admin/login";
        }
    }
	

	@GetMapping("/secured/index")
    public String securedList() {
		System.out.println("ok");
        return "/admin/secured/index";
    }

}
