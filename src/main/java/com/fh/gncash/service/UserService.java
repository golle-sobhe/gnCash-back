package com.fh.gncash.service;


import com.fh.gncash.dao.service.SellerDataService;
import com.fh.gncash.dao.service.UserDataService;
import com.fh.gncash.model.RoleType;
import com.fh.gncash.model.Seller;
import com.fh.gncash.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDataService userDataService;
    private final SellerDataService sellerDataService;

    public UserService(UserDataService userDataService, SellerDataService sellerDataService) {
        this.userDataService = userDataService;
        this.sellerDataService = sellerDataService;
    }

    public List<User> getAll() {
        return userDataService.getAll();
    }

    public User getById(String id) {
        return userDataService.getById(id);
    }

    public User create(User user) {
        return userDataService.create(user);
    }

    public User update(String id, User user) {
        return userDataService.update(id, user);
    }

    public void delete(String id) {
        userDataService.delete(id);
    }

    public List<User> getByRole(RoleType role) {
        return userDataService.getByRole(role);
    }

    public List<Seller> getSellerByAdmin(String adminId) {
        return sellerDataService.getByAdminId(adminId);
    }
}
