package com.fh.gncash.service;

import com.fh.gncash.dao.service.BenefiaciaryDataService;
import com.fh.gncash.model.Beneficiary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    private final BenefiaciaryDataService benefiaciaryDataService;

    public BeneficiaryService(BenefiaciaryDataService benefiaciaryDataService) {
        this.benefiaciaryDataService = benefiaciaryDataService;
    }

    public List<Beneficiary> getAll() {
        return benefiaciaryDataService.getAll();
    }

    public Beneficiary getById(String id) {
        return benefiaciaryDataService.getById(id);
    }

    public Beneficiary add(Beneficiary beneficiary) {
        return benefiaciaryDataService.create(beneficiary);
    }

    public Beneficiary update(String id, Beneficiary beneficiary) {
        return benefiaciaryDataService.update(id, beneficiary);
    }

    public void delete(String id) {
        benefiaciaryDataService.delete(id);
    }

    public Beneficiary toggle(String id) {
        return benefiaciaryDataService.toggle(id);
    }
}
