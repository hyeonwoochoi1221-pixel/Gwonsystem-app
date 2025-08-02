package com.gwonsystem.gwonsystem.controller;

import com.gwonsystem.gwonsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // templates/login.html
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // templates/signup.html
    }

    @PostMapping("/signup")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            userService.registerUser(username, password);
            return "redirect:/login"; // 회원가입 성공 시 로그인 페이지로 리다이렉트
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "signup"; // 실패 시 signup 페이지에 에러 메시지 표시
        }
    }
}