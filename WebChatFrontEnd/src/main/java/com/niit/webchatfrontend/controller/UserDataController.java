package com.niit.webchatfrontend.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.webchat.dao.UserDataDao;
import com.niit.webchat.model.UserData;
import com.niit.webchat.service.EmailService;

@Controller

public class UserDataController {

	@Autowired
	private UserDataDao userDataDao;
	
	
	@Autowired
	private EmailService emailService;

	private static final Logger log = LoggerFactory.getLogger(UserDataController.class);
	

	@RequestMapping(value = ("/edit"), method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("userData") UserData userData, BindingResult result) {
		if (result.hasErrors()) {
			return "Userprofile";

		}
		userDataDao.updateUser(userData);
		return "editUser";

	}
	
	@RequestMapping(value = "/update")
	public String profilePage(Principal p, Model model) {
		String email = p.getName();
		UserData userData = userDataDao.getUserByEmail(email);
		model.addAttribute("userData", userData);
		return "Userprofile";
	}

	@RequestMapping(value = ("/success"), method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userData") UserData userData, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "register";

		}
		userDataDao.addUser(userData);
		emailService.createdEmployeeMessage(userData, "This is Sample Email");
		model.addAttribute("success", "UserData" + userData.getName() + " registered successfully");

		return "success";

	}
	
	@GetMapping("/chat")
	public String chat() {
		
		return "chat";
	}
	}
	

