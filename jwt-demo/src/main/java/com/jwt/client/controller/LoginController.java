package com.jwt.client.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jwt.client.model.User;
import com.jwt.client.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {

	LoginService loginService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}
	@ModelAttribute("user")
	   public User setUpUserForm() {
	      return new User();
	   }
	
	@PostMapping("/login")
	public String login(@RequestParam("userName") String userName, @RequestParam("passWord") String password,
			Model model) {

		User user = new User(userName,password);
		user.setRole("admin");
		user.setUserId("123");
		loginService= new LoginService();
		if (loginService.login(user)) {
			model.addAttribute("user", user);
			return "registration";
		}
		return "error";
	}

}