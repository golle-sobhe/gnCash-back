package com.fh.gncash.dao.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("SELLER")
public class SellerEntity extends UserEntity {

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private UserEntity admin;
}
