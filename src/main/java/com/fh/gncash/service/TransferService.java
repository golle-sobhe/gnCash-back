package com.fh.gncash.service;

import com.fh.gncash.dao.service.TransferDataService;
import com.fh.gncash.model.Transfer;
import com.fh.gncash.model.TransferStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private final TransferDataService transferDataService;

    public TransferService(TransferDataService transferDataService) {
        this.transferDataService = transferDataService;
    }

    public List<Transfer> getAll() {
        return transferDataService.getAll();
    }

    public List<Transfer> getBySellerId(String sellerId) {
        return transferDataService.getBySellerId(sellerId);
    }

    public List<Transfer> getBySellerIds(String sellerIds) {
        return transferDataService.getBySellerIds(sellerIds);
    }

    public List<Transfer> getTransferByStatus(TransferStatus status) {
        return transferDataService.getByStatus(status);
    }

    public Transfer create(Transfer transfer) {
        return transferDataService.create(transfer);
    }

    public Transfer update(String id, Transfer transfer) {
        return transferDataService.update(id, transfer);
    }

    public void delete(String id) {
        transferDataService.delete(id);
    }

    public Transfer getByid(String id) {
        return transferDataService.getByid(id);
    }

    public List<Transfer> getByAdminIdAndStatus(String adminId, TransferStatus status) {
        return transferDataService.getByAdminIdAndStatus(adminId, status);
    }
}
