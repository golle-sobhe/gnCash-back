package com.fh.gncash.model;

public record User(String id,
        String phoneNumber,
        String firstName,
        String lastName,
        String idType,
        RoleType role) {
}
