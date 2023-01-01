package com.buimanhthanh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminSendMailController {

	/*
	 * @Autowired private JavaMailSender mailSender;
	 * 
	 * @RequestMapping("/send-email") public String sendEmail(Model model) {
	 * SimpleMailMessage message = new SimpleMailMessage();
	 * message.setFrom("manhthanh147@gmail.com");
	 * message.setTo("manhthanh147@gmail.com"); message.setSubject("Email Subject");
	 * message.setText("Email Body Heloooo"); mailSender.send(message);
	 * model.addAttribute("message", "Email sent successfully."); return
	 * "send-mail"; }
	 */
}
