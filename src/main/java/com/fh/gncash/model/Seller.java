package com.fh.gncash.model;

public record Seller(String id,
                     String phoneNumber,
                     String firstName,
                     String lastName,
                     String idType,
                     RoleType role,
                     String adminId) {
}
