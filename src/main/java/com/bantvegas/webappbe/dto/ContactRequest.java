package com.bantvegas.webappbe.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactRequest {

    @NotBlank(message = "Meno nesmie byť prázdne")
    private String name;

    @Email(message = "Neplatný formát e-mailu")
    @NotBlank(message = "Email nesmie byť prázdny")
    private String email;

    @NotBlank(message = "Správa nesmie byť prázdna")
    private String message;

    // Getter a setter pre meno
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter a setter pre email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter a setter pre message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
