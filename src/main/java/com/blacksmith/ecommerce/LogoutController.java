package com.blacksmith.ecommerce;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보를 제거
        session.removeAttribute("userEmail");
        // 세션을 완전히 무효화할 경우에는 session.invalidate()을 사용할 수도 있습니다.
        
        // 로그인 페이지로 리다이렉트
        return "redirect:/";
    }
}