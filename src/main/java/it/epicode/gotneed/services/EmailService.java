package it.epicode.gotneed.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {


    @Autowired
    private JavaMailSender emailSender;
    public void sendSimpleMessage(String recipient, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}

