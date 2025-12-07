package com.fh.gncash.dao.repository;

import com.fh.gncash.dao.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerJpaRepository extends JpaRepository<SellerEntity, String> {

    List<SellerEntity> findByAdminId(String adminId);
}
