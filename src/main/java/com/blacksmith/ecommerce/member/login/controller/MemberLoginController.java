package com.blacksmith.ecommerce.member.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;
import com.blacksmith.ecommerce.member.login.service.MemberLoginService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberLoginController {
	
	private final MemberLoginService memberLoginService;
	
    // 비밀번호 암호화를 위해 의존성 주입
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String registerForm() {
		return "/member/register_form";
	}
	
	@PostMapping("/register")
    public String register(UserDTO userDTO) {
        String encodedPassword = passwordEncoder.encode(userDTO.getUserPassword());
        userDTO.setUserPassword(encodedPassword);
        memberLoginService.register(userDTO);   
        return "redirect:/member/login";
    }
	
	@GetMapping("/login")
	public String memberLoginFrom() {
		return "/member/member_login";
	}
	
	
	@PostMapping("/login")
	public String memberLogin(@ModelAttribute UserDTO userDTO, HttpSession session) {
	    // 사용자가 입력한 아이디로 데이터베이스에서 사용자 정보 조회
	    UserDTO storedUser = memberLoginService.memberLogin(userDTO.getUserEmail());
	    
	    // 사용자 정보가 없거나 비밀번호가 일치하지 않으면 로그인 실패
	    if (storedUser == null || !passwordEncoder.matches(userDTO.getUserPassword(), storedUser.getUserPassword())) {
	        return "/member/member_login"; // 로그인 페이지로 이동
	    }

	    // 로그인 성공 시 세션에 사용자 이메일을 저장하고 보호된 페이지로 리다이렉트
	    session.setAttribute("memberEmail", storedUser.getUserEmail());
	    return "redirect:/member/secured/index";
	}
	
	@GetMapping("/secured/index")
	public String welcome() {
		return "/member/secured/index";
	}
	

//	@GetMapping("/secured/test1")
//	public String member1() {
//		return "/member/secured/test1";
//	}
//	@GetMapping("/secured/test2")
//	public String member2() {
//		return "/member/secured/test2";
//	}
	
}
