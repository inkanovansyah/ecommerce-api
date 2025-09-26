package com.ecommerce.ecommerce_api.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce_api.dto.ApiResponse;
import com.ecommerce.ecommerce_api.dto.VendorDTO;
import com.ecommerce.ecommerce_api.model.Vendor;
import com.ecommerce.ecommerce_api.service.VendorService;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    // GET dengan pagination
    @GetMapping
    public ApiResponse<Page<VendorDTO>> getAllVendors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<VendorDTO> vendors = vendorService.getAllVendors(PageRequest.of(page, size));
        return new ApiResponse<>(true, "Berhasil ambil data vendor", vendors);
    }

    // GET by ID
    @GetMapping("/{id}")
    public ApiResponse<Optional<VendorDTO>> getVendorById(@PathVariable Long id) {
        return new ApiResponse<>(true, "Berhasil ambil data vendor", vendorService.getVendorById(id));
    }

    // CREATE
    @PostMapping
    public ApiResponse<VendorDTO> createVendor(@RequestBody Vendor vendor) {
        return new ApiResponse<>(true, "Vendor berhasil dibuat", vendorService.createVendor(vendor));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ApiResponse<Optional<VendorDTO>> updateVendor(@PathVariable Long id, @RequestBody Vendor vendor) {
        return new ApiResponse<>(true, "Vendor berhasil diupdate", vendorService.updateVendor(id, vendor));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteVendor(@PathVariable Long id) {
        return new ApiResponse<>(true, "Vendor berhasil dihapus", vendorService.deleteVendor(id));
    }
}
