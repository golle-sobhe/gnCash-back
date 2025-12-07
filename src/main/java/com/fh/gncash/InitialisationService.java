package com.fh.gncash;

import com.fh.gncash.model.Beneficiary;
import com.fh.gncash.model.User;
import com.fh.gncash.service.BeneficiaryService;
import com.fh.gncash.service.TransferService;
import com.fh.gncash.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class InitialisationService {

    private final UserService userService;
    private final BeneficiaryService beneficiaryService;
    private final TransferService transferService;

    public InitialisationService(UserService userService, BeneficiaryService beneficiaryService, TransferService transferService) {
        this.userService = userService;
        this.beneficiaryService = beneficiaryService;
        this.transferService = transferService;
    }

    @PostConstruct
    public void init() {
        loadUsers();
        loadBeneficiaries();
    }

    private void loadUsers() {
        User fiya = new User("1a2b3c4d-0001", "+33612345678", "Fiya", "Hollo", null, null);
        userService.create(fiya);
        User alice = new User("1a2b3c4d-0002", "+33687654321", "Alice", "Dupont", null, null);
        userService.create(alice);
        User bob = new User("1a2b3c4d-0003", "+33611122233", "Bob", "Martin", null, null);
        userService.create(bob);
        User test = new User("1a2b3c4d-0005", "+33999988877", "Test", "User", null, null);
        userService.create(test);
    }

    private void loadBeneficiaries() {
        Beneficiary b1 = new Beneficiary("1", "Jean", "Dupont", "+33612345678", "https://i.pravatar.cc/150?img=1", true);
        beneficiaryService.add(b1);
        Beneficiary b2 = new Beneficiary("2", "Marie", "Curie", "+33687654321", "https://i.pravatar.cc/150?img=2", false);
        beneficiaryService.add(b2);
        Beneficiary b3 = new Beneficiary("3", "Pierre", "Moreau", "+33698765432", "https://i.pravatar.cc/150?img=3", true);
        beneficiaryService.add(b3);
        Beneficiary b4 = new Beneficiary("4", "Sophie", "Bernard", "+33712345678", "https://i.pravatar.cc/150?img=4", false);
        beneficiaryService.add(b4);
        Beneficiary b5 = new Beneficiary("5", "Luc", "Fontaine", "+33723456789", "https://i.pravatar.cc/150?img=5", true);
        beneficiaryService.add(b5);
    }

    private void loadTransfers() {
        
    }

}
