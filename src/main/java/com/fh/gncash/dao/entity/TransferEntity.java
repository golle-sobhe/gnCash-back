package com.fh.gncash.dao.entity;

import com.fh.gncash.model.TransferStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class TransferEntity {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private SellerEntity seller;
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private BeneficiaryEntity recipient;
    private BigDecimal amount;
    private BigDecimal fees;
    private BigDecimal rate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private TransferStatus status;
    private LocalDateTime date;
    private String code;
}
