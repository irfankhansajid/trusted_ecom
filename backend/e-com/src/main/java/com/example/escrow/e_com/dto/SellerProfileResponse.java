package com.example.escrow.e_com.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SellerProfileResponse {
    
    private Long id;
    private String businessName;
    private String businessAddress;
    private String description;
    private boolean isVerified;
    private boolean isApproved;
}
