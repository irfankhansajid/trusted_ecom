package com.example.escrow.e_com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.escrow.e_com.dto.SellerApplyRequest;
import com.example.escrow.e_com.dto.SellerProfileResponse;
import com.example.escrow.e_com.entity.Seller;
import com.example.escrow.e_com.service.SellerService;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/apply") 
    public ResponseEntity<Seller> applyAsSeller(@RequestBody SellerApplyRequest request, @RequestParam Long userId){

        if (userId == null) {
            return ResponseEntity.badRequest().build();
        }
        if (request == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(sellerService.applyAsSeller(userId, request));
    }

    @PutMapping("/approve")
    public ResponseEntity<Seller> approveSeller(@RequestParam Long sellerId){
        if (sellerId == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(sellerService.approveSeller(sellerId));
    }

    @GetMapping("/profile")
    public ResponseEntity<SellerProfileResponse> getSellerProfileResponse(@RequestParam Long sellerId){
        if (sellerId == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(sellerService.getSellerProfileResponse(sellerId));
    }


    
}
