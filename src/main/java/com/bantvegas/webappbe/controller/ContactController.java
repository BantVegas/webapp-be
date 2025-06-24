package com.bantvegas.webappbe.controller;

import com.bantvegas.webappbe.service.EmailService;
import com.bantvegas.webappbe.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendContactForm(@Validated @RequestBody ContactRequest request) {
        // Skladanie správy
        String subject = "Nová správa z kontaktného formulára";
        String body = String.format(
                "Meno: %s\nEmail: %s\nSpráva:\n%s",
                request.getName(), request.getEmail(), request.getMessage()
        );

        // Pošli email (z GMail na svoj GMail)
        emailService.sendContactEmail("lukacm14@gmail.com", subject, body);

        return ResponseEntity.ok().body("Správa bola úspešne odoslaná");
    }
}
