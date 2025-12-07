package com.fh.gncash.controller;

import com.fh.gncash.model.Beneficiary;
import com.fh.gncash.service.BeneficiaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;

    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @GetMapping
    public List<Beneficiary> getAllBeneficiaries() {
        return beneficiaryService.getAll();
    }

    @GetMapping("/{id}")
    public Beneficiary getById(@PathVariable String id) {
        return beneficiaryService.getById(id);
    }

    @PostMapping
    public Beneficiary addBeneficiary(@RequestBody Beneficiary beneficiary) {
        return beneficiaryService.add(beneficiary);
    }

    @PutMapping("/{id}")
    public Beneficiary updateBeneficiary(@PathVariable String id, @RequestBody Beneficiary beneficiary) {
        return beneficiaryService.update(id, beneficiary);
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable String id) {
        beneficiaryService.delete(id);
    }

    @PatchMapping("/{id}/favorite")
    public Beneficiary toggleFavorite(@PathVariable String id) {
        return beneficiaryService.toggle(id);
    }
}
