package com.jwt.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jwt.client.model.User;
import com.jwt.client.service.DbService;
import com.jwt.client.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {

	LoginService loginService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("userName") String userName, @RequestParam("passWord") String password,
			Model model) {

		User user = new User(userName, password);
		user.setRole("admin");
		loginService = new LoginService();
		String token = loginService.login(user);
		if (token != null) {
			DbService.tokenMap.put("token", token);
			model.addAttribute("user", user);
			model.addAttribute("token", token);
			return "registration";
		}
		return "error";
	}

}