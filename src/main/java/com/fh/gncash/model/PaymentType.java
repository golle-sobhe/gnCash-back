package com.fh.gncash.model;

public enum PaymentType {

    Transfer("Transfer"),
    Load("Load");

    private final String type;

    PaymentType(String type) {
        this.type = type;
    }
}
