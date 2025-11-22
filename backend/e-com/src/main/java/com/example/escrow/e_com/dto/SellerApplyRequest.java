package com.example.escrow.e_com.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SellerApplyRequest {
    
    @NotBlank
    private String businessName;
    
    @NotBlank
    private String businessAddress;
    
    @NotBlank
    private String nidNumber;
    
    @NotBlank
    private String description;
    
    @NotBlank
    private String tradeLicenseNumber;
}
