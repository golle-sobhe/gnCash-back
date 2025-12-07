package com.fh.gncash.dao.mapper;

import com.fh.gncash.dao.entity.SellerEntity;
import com.fh.gncash.dao.entity.UserEntity;
import com.fh.gncash.model.Seller;

public class SellerMapper {

    public static SellerEntity toEntity(Seller seller) {
        if (seller == null) {
            return null;
        }
        SellerEntity entity = new SellerEntity();
        entity.setId(seller.id());
        entity.setPhoneNumber(seller.phoneNumber());
        entity.setFirstName(seller.firstName());
        entity.setLastName(seller.lastName());
        entity.setIdType(seller.idType());
        entity.setRole(seller.role());

        if (seller.adminId() != null) {
            UserEntity adminRef = new UserEntity();
            adminRef.setId(seller.adminId());
            entity.setAdmin(adminRef);
        } else {
            entity.setAdmin(null);
        }
        return entity;
    }

    public static Seller toModel(SellerEntity entity) {
        if (entity == null) {
            return null;
        }
        String adminId = entity.getAdmin() != null ? entity.getAdmin().getId() : null;
        return new Seller(
                entity.getId(),
                entity.getPhoneNumber(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getIdType(),
                entity.getRole(),
                adminId
        );
    }
}
