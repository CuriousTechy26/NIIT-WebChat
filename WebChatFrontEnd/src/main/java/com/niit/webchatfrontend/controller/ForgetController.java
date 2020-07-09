package com.niit.webchatfrontend.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.webchat.dao.UserDataDao;
import com.niit.webchat.model.UserData;
import com.niit.webchat.service.EmailService;

@Controller
public class ForgetController {
	@Autowired
	private UserData userData;
	@Autowired
	private UserDataDao userDataDao;
	@Autowired
	private EmailService emailService;
	static String myRandomNumber = "";
	static String email = "";

	@RequestMapping(value = ("/forget"))
	public String forgetPage(Model model) {
		model.addAttribute("userData", new UserData());
		model.addAttribute("title", "forgetPage");
		/*
		 * if(userData.getUserEmail()==) {
		 * 
		 * } Random random = new Random(); int randNumber=random.nextInt(1000000);
		 * userData.setOtp(randNumber); emailService.createdUserMessage(userInfo,
		 * message);
		 */
		return "forget";
	}

	@RequestMapping(value = ("/generate-otp"))
	public String otpPage(@ModelAttribute("userData") UserData userData, Model model) {

		List<UserData> users = userDataDao.getAllUsers();
		boolean isEmailValid = false;

		for (UserData user : users) {

			if (user.getEmail().equalsIgnoreCase(userData.getEmail())) {
				isEmailValid = true;
				email = user.getEmail();
			}
		}

		if (isEmailValid) {
			String randomNumber = getRandomNumberString();
			myRandomNumber = randomNumber;
			System.out.println("My Random Nymber is : " + myRandomNumber);
			emailService.createdEmployeeMessage(userData, "\nYour OTP is " + randomNumber);

		} else {
			return "redirect:/forget";
		}
		return "verifyOtp";
	}

	@RequestMapping(value = ("/otpverify"))
	public String updatePasswordPage(@ModelAttribute("userData") UserData userData, Model model) {

		if (userData.getOtp() == Integer.parseInt(myRandomNumber)) {
			model.addAttribute("userData", userData);
			model.addAttribute("title", "Update Password");
			return "updatePassword";
		} else {
			return "redirect:/generate-otp";
		}

	}

	@RequestMapping(value = "/passwordUpdate", method = RequestMethod.POST)
	public String otpVerifyPage(@ModelAttribute("userInfo") UserData userData) {
		UserData user = userDataDao.getUserByEmail(email);
		user.setPassword(userData.getPassword());
		user.setConfirmPassword(userData.getConfirmPassword());

		userDataDao.updateUser(user);
		emailService.createdEmployeeMessage(user,
				"\nYour password has been updated Successfully\n The Updates password is " + userData.getPassword());
		return "login";

	}

	private String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}

}
