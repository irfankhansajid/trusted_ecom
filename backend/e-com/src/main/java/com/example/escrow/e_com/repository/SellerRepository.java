package com.example.escrow.e_com.repository;

import com.example.escrow.e_com.entity.Seller;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    
    Optional<Seller> findByUserId(Long userId);
    boolean existsByUserId(Long userId);

}
