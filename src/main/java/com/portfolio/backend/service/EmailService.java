package com.portfolio.backend.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactEmail(String senderName, String senderEmail, String message) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("poonkanikannan@gmail.com");
        mail.setSubject("Portfolio Contact Message");
        mail.setText(
                "Name: " + senderName +
                        "\nEmail: " + senderEmail +
                        "\n\nMessage:\n" + message);

        mailSender.send(mail);
    }
}
