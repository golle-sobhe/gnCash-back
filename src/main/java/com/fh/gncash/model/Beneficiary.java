package com.fh.gncash.model;

public record Beneficiary(String id,
                          String firstName,
                          String lastName,
                          String phoneNumber,
                          String avatar,
                          Boolean favorite) {
}
