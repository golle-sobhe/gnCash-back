package com.fh.gncash.dao.repository;

import com.fh.gncash.dao.entity.BeneficiaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryJpaRepository extends JpaRepository<BeneficiaryEntity, String> {
}
