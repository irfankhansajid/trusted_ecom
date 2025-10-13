package com.example.escrow.e_com.dto;

import com.example.escrow.e_com.entity.Role;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Role role;

}
