package com.fh.gncash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record User(String id,
                String phoneNumber,
                @JsonIgnore String password,
                String firstName,
                String lastName,
                String idType,
                RoleType role) {
}
