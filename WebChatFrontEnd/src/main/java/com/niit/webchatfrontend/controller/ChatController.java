package com.niit.webchatfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.webchat.dao.UserDataDao;
import com.niit.webchat.model.Chat;
import com.niit.webchat.model.ChatMessage;
import com.niit.webchat.model.UserData;

@Controller
public class ChatController {
	@Autowired
	private UserData userData;
	@Autowired
	private UserDataDao userDataDao;

	@RequestMapping(value = ("/chat"))
	public String chatPage(Model model) {
		model.addAttribute("userData", userData);
		model.addAttribute("title", "Chat");
		return "chat";
	}
	
	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public Chat register(@Payload Chat chat, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", chat.getSender());
		return chat;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

}