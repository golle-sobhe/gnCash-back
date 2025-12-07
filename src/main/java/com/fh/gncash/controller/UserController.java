package com.fh.gncash.controller;

import com.fh.gncash.model.RoleType;
import com.fh.gncash.model.Seller;
import com.fh.gncash.model.User;
import com.fh.gncash.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User create(@PathVariable String id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    //@GetMapping()
    public List<User> getByRole(@RequestParam(name = "role") RoleType role) {
        return userService.getByRole(role);
    }

    //@GetMapping()
    public List<Seller> getSellersByAdminId(@RequestParam(name = "sellerOf") String adminId) {
        return userService.getSellerByAdmin(adminId);
    }

}
