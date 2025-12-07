package com.fh.gncash.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class BeneficiaryEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String avatar;
    private Boolean favorite;

}
