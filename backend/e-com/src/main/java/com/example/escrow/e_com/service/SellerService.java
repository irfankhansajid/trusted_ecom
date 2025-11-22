package com.example.escrow.e_com.service;

import com.example.escrow.e_com.entity.Seller;


import com.example.escrow.e_com.dto.SellerApplyRequest;
import com.example.escrow.e_com.dto.SellerProfileResponse;

public interface SellerService {
    
    public Seller applyAsSeller(Long userId, SellerApplyRequest request);

    public Seller approveSeller(Long sellerId);

    public SellerProfileResponse getSellerProfileResponse(Long sellerId);

}
