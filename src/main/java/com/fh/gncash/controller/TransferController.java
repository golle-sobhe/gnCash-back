package com.fh.gncash.controller;

import com.fh.gncash.model.Transfer;
import com.fh.gncash.model.TransferStatus;
import com.fh.gncash.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public List<Transfer> getAllTransfers() {
        return transferService.getAll();
    }

    //@GetMapping
    public List<Transfer> getTransfersBySeller(@RequestParam(name = "sellerId") String sellerId) {
        return transferService.getBySellerId(sellerId);
    }

    //@GetMapping
    public List<Transfer> getTransfersBySellers(@RequestParam(name = "sellerIds") String sellerIds) {
        return transferService.getBySellerIds(sellerIds);
    }

    //@GetMapping
    public List<Transfer> getTransfersByStatus(@RequestParam(name = "status") TransferStatus status) {
        return transferService.getTransferByStatus(status);
    }

    @PostMapping
    public Transfer create(@RequestBody Transfer transfer) {
        return transferService.create(transfer);
    }

    @PutMapping("/{id}")
    public Transfer update(@PathVariable String id, @RequestBody Transfer transfer) {
        return transferService.update(id, transfer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        transferService.delete(id);
    }

    @GetMapping("/{id}")
    public Transfer getById(@PathVariable String id) {
        return transferService.getByid(id);
    }

    //@GetMapping
    public List<Transfer> getByAdminIdAndStatus(@RequestParam(name = "adminId") String adminId,
                                                @RequestParam(name = "status") TransferStatus status) {
        return transferService.getByAdminIdAndStatus(adminId, status);
    }
}
