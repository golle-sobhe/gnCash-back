package com.fh.gncash.dao.service;

import com.fh.gncash.dao.entity.TransferEntity;
import com.fh.gncash.dao.mapper.TransferMapper;
import com.fh.gncash.dao.repository.TransferJpaRepository;
import com.fh.gncash.model.Transfer;
import com.fh.gncash.model.TransferStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferDataService {

    private final TransferJpaRepository transferJpaRepository;

    public TransferDataService(TransferJpaRepository transferJpaRepository) {
        this.transferJpaRepository = transferJpaRepository;
    }

    public List<Transfer> getAll() {
        return transferJpaRepository.findAll()
                .stream()
                .map(TransferMapper::toModel)
                .toList();
    }

    public List<Transfer> getBySellerId(String sellerId) {
        return transferJpaRepository.findBySellerId(sellerId)
                .stream()
                .map(TransferMapper::toModel)
                .toList();
    }


    public List<Transfer> getByStatus(TransferStatus status) {
        return transferJpaRepository.findByStatus(status)
                .stream()
                .map(TransferMapper::toModel)
                .toList();
    }

    public Transfer create(Transfer transfer) {
        TransferEntity entity = TransferMapper.toEntity(transfer);
        return TransferMapper.toModel(transferJpaRepository.save(entity));
    }

    public Transfer update(String id, Transfer transfer) {
        TransferEntity entity = transferJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        entity.setStatus(transfer.status());
        entity.setAmount(transfer.amount());
        entity.setFees(transfer.fees());
        entity.setRate(transfer.rate());
        entity.setCurrency(transfer.currency());
        entity.setDate(transfer.date());
        entity.setCode(transfer.code());
        return TransferMapper.toModel(transferJpaRepository.save(entity));
    }

    public void delete(String id) {
        transferJpaRepository.deleteById(id);
    }

    public Transfer getByid(String id) {
        return transferJpaRepository.findById(id)
                .map(TransferMapper::toModel)
                .orElse(null);
    }

    public List<Transfer> getByAdminIdAndStatus(String adminId, TransferStatus status) {
        //TODO
        return List.of();
    }

    public List<Transfer> getBySellerIds(String sellerIds) {
        //TODO
        return List.of();
    }
}
