package com.example.demo.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "name {invalid.required}")
    private String name;
    @NotBlank(message = "email {invalid.required}")
    @Email(message = "Format email should be username@domain.gTLDs&ccTLDs", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    private String email;

    @NotBlank(message = "phone {invalid.required}")
    @Pattern(regexp = "^[0-9+_.-]", message = "input failed")
    private String phone;
    @NotBlank(message = "password {invalid.required}")
    private String password;
}
