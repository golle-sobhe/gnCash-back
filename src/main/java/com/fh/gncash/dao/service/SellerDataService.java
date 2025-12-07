package com.fh.gncash.dao.service;

import com.fh.gncash.dao.mapper.SellerMapper;
import com.fh.gncash.dao.repository.SellerJpaRepository;
import com.fh.gncash.model.Seller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerDataService {

    private final SellerJpaRepository sellerJpaRepository;

    public SellerDataService(SellerJpaRepository sellerJpaRepository) {
        this.sellerJpaRepository = sellerJpaRepository;
    }

    public List<Seller> getByAdminId(String adminId) {
        return sellerJpaRepository.findByAdminId(adminId)
                .stream()
                .map(SellerMapper::toModel).toList();
    }
}
