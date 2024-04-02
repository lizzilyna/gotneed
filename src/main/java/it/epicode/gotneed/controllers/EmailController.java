package it.epicode.gotneed.controllers;

import it.epicode.gotneed.models.EmailDetails;
import it.epicode.gotneed.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailDetails emailDetails) {
        emailService.sendSimpleMessage(emailDetails.getRecipient(), emailDetails.getSubject(), emailDetails.getMessage());
    }
}
