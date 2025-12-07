package com.fh.gncash.model;

public enum RoleType {

    Regular("regular"),
    Super("super"),
    Admin("admin"),
    Seller("seller");

    private String role;

    RoleType(String role) {
        this.role = role;
    }
}
