package com.fh.gncash.dao.repository;

import com.fh.gncash.dao.entity.TransferEntity;
import com.fh.gncash.model.TransferStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferJpaRepository extends JpaRepository<TransferEntity, String> {

    List<TransferEntity> findBySellerId(String sellerId);

    List<TransferEntity> findByStatus(TransferStatus status);
}
