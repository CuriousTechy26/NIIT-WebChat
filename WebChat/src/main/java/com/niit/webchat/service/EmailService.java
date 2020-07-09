package com.niit.webchat.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.niit.webchat.model.UserData;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

@Service( value="emailService")
public class EmailService {

	
	@Autowired
	private JavaMailSender mailSender;

	private static String from = "WebChat";

	public void createdEmployeeMessage(UserData userData,String message) {

		
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = null;

	

			
			try {
				helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

				
				StringBuilder htmlMsg = new StringBuilder();

				htmlMsg.append("<h1>Welcome " + userData.getName() + " on WebChat!</h1>");
				htmlMsg.append("<p>"+message+"</p><br/>");
				htmlMsg.append("<p>Thanks for joining with us!</p><br/>");

				
				mimeMessage.setContent(htmlMsg.toString(), "text/html");
				helper.setTo(userData.getEmail());
				helper.setSubject("WELCOME TO WebChat");
				helper.setFrom(from);

				
				mailSender.send(mimeMessage);
		} catch (MailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (javax.mail.MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          			
		
		
	}


}