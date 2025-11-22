package com.example.escrow.e_com.service.serviceImpl;

import com.example.escrow.e_com.dto.SellerApplyRequest;
import com.example.escrow.e_com.dto.SellerProfileResponse;
import com.example.escrow.e_com.entity.Role;
import com.example.escrow.e_com.entity.Seller;
import com.example.escrow.e_com.entity.User;
import com.example.escrow.e_com.exception.AlreadyExistsException;
import com.example.escrow.e_com.exception.UserNotFoundException;
import com.example.escrow.e_com.repository.SellerRepository;
import com.example.escrow.e_com.repository.UserRepository;
import com.example.escrow.e_com.service.SellerService;

import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;

    public SellerServiceImpl(SellerRepository sellerRepository, UserRepository userRepository) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Seller applyAsSeller(Long userId, SellerApplyRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
       
        if (sellerRepository.existsByUserId(userId)) {
            throw new AlreadyExistsException("User already applied as seller");
        }
        Seller seller = Seller.builder()
        .user(user)
        .businessName(request.getBusinessName())
        .businessAddress(request.getBusinessAddress())
        .description(request.getDescription())
        .nidNumber(request.getNidNumber())
        .tradeLicenseNumber(request.getTradeLicenseNumber())
        .isVerified(false)
        .isApproved(false)
        .build();

        
        return sellerRepository.save(seller);
    }

    @Override
    public Seller approveSeller(Long sellerId) {

        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        seller.setApproved(true);
        seller.setVerified(true);

        User user = seller.getUser();
        user.setRole(Role.SELLER);

        userRepository.save(user);


        return sellerRepository.save(seller);
        
    }

    @Override
    public SellerProfileResponse getSellerProfileResponse(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return SellerProfileResponse.builder()
                .id(seller.getId())
                .businessName(seller.getBusinessName())
                .businessAddress(seller.getBusinessAddress())
                .description(seller.getDescription())
                .isVerified(seller.isVerified())
                .isApproved(seller.isApproved())
                .build();
    }  
        
}
