package com.example.escrow.e_com.dto;

import com.example.escrow.e_com.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class UserRegisterRequest {

    private Long id;

    @Size(min = 6, max = 50)
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Size(min = 6, max = 50)
    @NotBlank
    private String password;

    private Role role;


}
