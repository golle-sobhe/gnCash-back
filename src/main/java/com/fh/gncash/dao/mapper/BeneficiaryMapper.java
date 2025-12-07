package com.fh.gncash.dao.mapper;

import com.fh.gncash.dao.entity.BeneficiaryEntity;
import com.fh.gncash.model.Beneficiary;

public class BeneficiaryMapper {

    public static BeneficiaryEntity toEntity(Beneficiary beneficiary) {
        if (beneficiary == null) {
            return null;
        }
        BeneficiaryEntity entity = new BeneficiaryEntity();
        entity.setId(beneficiary.id());
        entity.setFirstName(beneficiary.firstName());
        entity.setLastName(beneficiary.lastName());
        entity.setPhoneNumber(beneficiary.phoneNumber());
        entity.setAvatar(beneficiary.avatar());
        entity.setFavorite(beneficiary.favorite());
        return entity;
    }

    public static Beneficiary toModel(BeneficiaryEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Beneficiary(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getPhoneNumber(),
                entity.getAvatar(),
                entity.getFavorite()
        );
    }
}
