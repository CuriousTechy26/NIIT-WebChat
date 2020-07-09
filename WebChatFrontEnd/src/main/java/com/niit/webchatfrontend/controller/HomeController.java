package com.niit.webchatfrontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.webchat.model.UserData;

@Controller

public class HomeController {

	@Autowired
	private UserData userData;
	
	private static final Logger log = LoggerFactory.getLogger(UserDataController.class);

	@RequestMapping(value = { "/", "/index" })
	public String homePage(Model model) {
		model.addAttribute("title", "Home");
		return "index";
	}

	@RequestMapping(value = ("/login"))
	public String loginPage(Model model) {
		model.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping(value = ("/register"))
	public String registerPage(Model model) {
		model.addAttribute("title", "Register");
		model.addAttribute("userData", userData);
		return "register";
	}
	
	@RequestMapping(value = ("/logout"))
	public String logoutPage(Model model) {
		model.addAttribute("msg", "Logout successfully");
		return "login";
	}
	
	@RequestMapping(value = ("/user/Home"))
	public String userPage(Model model) {

		model.addAttribute("title", "Admin");
		return "userPage";
	}
	
	@RequestMapping(value = ("/Userprofile"))
	public String profilePage(Model model) {
		model.addAttribute("title", "Profile");
		model.addAttribute("userData", userData);
		return "Userprofile";
	}

}
