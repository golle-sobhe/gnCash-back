package com.fh.gncash.dao.mapper;

import com.fh.gncash.dao.entity.TransferEntity;
import com.fh.gncash.model.Transfer;

public class TransferMapper {
    public static TransferEntity toEntity(Transfer transfer) {
        if (transfer == null) {
            return null;
        }
        TransferEntity entity = new TransferEntity();
        entity.setId(transfer.id());
        // Nested relations
        entity.setSeller(SellerMapper.toEntity(transfer.seller()));
        entity.setRecipient(BeneficiaryMapper.toEntity(transfer.recipient()));
        // Scalars
        entity.setAmount(transfer.amount());
        entity.setFees(transfer.fees());
        entity.setRate(transfer.rate());
        entity.setCurrency(transfer.currency());
        entity.setStatus(transfer.status());
        entity.setDate(transfer.date());
        entity.setCode(transfer.code());
        return entity;
    }

    public static Transfer toModel(TransferEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Transfer(
                entity.getId(),
                SellerMapper.toModel(entity.getSeller()),
                BeneficiaryMapper.toModel(entity.getRecipient()),
                entity.getAmount(),
                entity.getFees(),
                entity.getRate(),
                entity.getCurrency(),
                entity.getStatus(),
                entity.getDate(),
                entity.getCode()
        );
    }
}
