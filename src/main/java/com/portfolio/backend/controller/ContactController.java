package com.portfolio.backend.controller;

import com.portfolio.backend.model.ContactMessage;
import com.portfolio.backend.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String handleMessage(@RequestBody ContactMessage msg) {

        // Email only (NO DATABASE)
        emailService.sendContactEmail(
                msg.getName(),
                msg.getEmail(),
                msg.getMessage());

        return "Message Sent Successfully!";
    }
}
