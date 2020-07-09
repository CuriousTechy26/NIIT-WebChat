package com.niit.webchatfrontend.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.webchat.dao.UserDataDao;
import com.niit.webchat.model.UserData;

@Controller

public class AdminController {

	@Autowired
	private UserDataDao userDataDao;

	private static final Logger log = LoggerFactory.getLogger(UserDataController.class);

	@RequestMapping(value = ("/admin/Home"))
	public String adminPage(Model model) {

		model.addAttribute("title", "Admin");
		return "admin";
	}

	@RequestMapping(value = ("/userList"))
	public String adminUserList(Model model) {
		model.addAttribute("userList", userDataDao.getAllUsers());
		model.addAttribute("title", "UserList");
		return "userList";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {

		UserData user = userDataDao.getUserByUserId(id);
		userDataDao.deleteUser(user);
		return "redirect:/admin/Home";

	}

	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {

		UserData user = userDataDao.getUserByUserId(id);
		model.addAttribute("userData", user);
		return "Userprofile";

	}
	
}
