package com.fh.gncash.dao.entity;

import com.fh.gncash.model.RoleType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public class UserEntity {

    @Id
    private String id;
    private String phoneNumber;
    private String password;
    private String firstName;
    private String lastName;
    private String idType;
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
