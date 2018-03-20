package com.jwt.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.client.model.RegistrationForm;
import com.jwt.client.service.RegistrationService;

import ch.qos.logback.core.net.SyslogOutputStream;


@Controller
public class RegistrationController {
	
RegistrationService registrationService;
	
	@PostMapping("/registration")
	   public String register(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, 
			   @RequestParam("street") String street,@RequestParam("city") String city,@RequestParam("zipCode") String zipCode,
			   @RequestParam("state") String state,@RequestParam("email") String email,@RequestParam("phone") String phone, Model model) {
		
		RegistrationForm form= new RegistrationForm();
		form.setFirstName(firstName);
		form.setLastName(lastName);
		form.setStreet(street);
		form.setCity(city);
		form.setZipCode(zipCode);
		form.setState(state);
		form.setEmail(email);
		form.setPhone(phone);
		
		registrationService= new RegistrationService();
		
	if (registrationService.register(form))	{
		 model.addAttribute("form", form);	
		
	      return "usersList";     
	}
	return "errorPage";
	   }

	
	@GetMapping("/usersList")	
	public ModelAndView getAllRegisteredUsers()
	{
		List<RegistrationForm> resultsList = new ArrayList<RegistrationForm>();
		 resultsList = registrationService.getAllRegisteredUsers();		
		 if(resultsList.isEmpty()) return null;		
		ModelAndView  model = new ModelAndView("usersList");
		resultsList = registrationService.getAllRegisteredUsers();		
		resultsList.forEach(l->System.out.println(l.toString()));
		if(resultsList.isEmpty()) return null;
		model.addObject("lists",resultsList);
		
		return model;
		
	}
	
}
