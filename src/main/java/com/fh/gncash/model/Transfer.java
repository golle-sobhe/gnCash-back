package com.fh.gncash.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transfer(String id,
                       Seller seller,
                       Beneficiary recipient,
                       BigDecimal amount,
                       BigDecimal fees,
                       BigDecimal rate,
                       String currency,
                       TransferStatus status,
                       LocalDateTime date,
                       String code) {
}
