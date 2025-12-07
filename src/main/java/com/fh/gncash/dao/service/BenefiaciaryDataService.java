package com.fh.gncash.dao.service;

import com.fh.gncash.dao.entity.BeneficiaryEntity;
import com.fh.gncash.dao.mapper.BeneficiaryMapper;
import com.fh.gncash.dao.repository.BeneficiaryJpaRepository;
import com.fh.gncash.model.Beneficiary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenefiaciaryDataService {

    private final BeneficiaryJpaRepository beneficiaryJpaRepository;

    public BenefiaciaryDataService(BeneficiaryJpaRepository beneficiaryJpaRepository) {
        this.beneficiaryJpaRepository = beneficiaryJpaRepository;
    }


    public List<Beneficiary> getAll() {
        return beneficiaryJpaRepository.findAll()
                .stream()
                .map(BeneficiaryMapper::toModel)
                .toList();
    }

    public Beneficiary getById(String id) {
        return beneficiaryJpaRepository.findById(id)
                .map(BeneficiaryMapper::toModel)
                .orElse(null);
    }

    public Beneficiary create(Beneficiary beneficiary) {
        BeneficiaryEntity entity = BeneficiaryMapper.toEntity(beneficiary);
        return BeneficiaryMapper.toModel(beneficiaryJpaRepository.save(entity));
    }

    public Beneficiary update(String id, Beneficiary beneficiary) {
        BeneficiaryEntity entity = beneficiaryJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        entity.setFirstName(beneficiary.firstName());
        entity.setLastName(beneficiary.lastName());
        entity.setPhoneNumber(beneficiary.phoneNumber());
        entity.setAvatar(beneficiary.avatar());
        entity.setFavorite(beneficiary.favorite());
        return BeneficiaryMapper.toModel(beneficiaryJpaRepository.save(entity));
    }

    public void delete(String id) {
        beneficiaryJpaRepository.deleteById(id);
    }

    public Beneficiary toggle(String id) {
        BeneficiaryEntity entity = beneficiaryJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        entity.setFavorite(!entity.getFavorite());
        return BeneficiaryMapper.toModel(beneficiaryJpaRepository.save(entity));
    }
}
