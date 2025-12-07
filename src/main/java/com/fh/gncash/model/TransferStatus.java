package com.fh.gncash.model;

public enum TransferStatus {

    Pending("pending"),
    Completed("completed"),
    Failed("failed");

    private String status;

    TransferStatus(String status) {
        this.status = status;
    }
}
