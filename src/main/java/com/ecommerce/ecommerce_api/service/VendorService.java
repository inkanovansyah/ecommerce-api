package com.ecommerce.ecommerce_api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce_api.dto.VendorDTO;
import com.ecommerce.ecommerce_api.model.Vendor;
import com.ecommerce.ecommerce_api.repository.VendorRepository;

@Service
public class VendorService {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // Ambil semua dengan pagination
    public Page<VendorDTO> getAllVendors(Pageable pageable) {
        return vendorRepository.findAll(pageable)
                .map(v -> new VendorDTO(
                        v.getId(),
                        v.getVendorName(),
                        v.getDescription(),
                        v.getPhone(),
                        v.getAddress(),
                        v.getIsActive(),
                        v.getImageUrl() // ✅ tambahkan imageUrl
                ));
    }

    // Ambil berdasarkan ID
    public Optional<VendorDTO> getVendorById(Long id) {
        return vendorRepository.findById(id)
                .map(v -> new VendorDTO(
                        v.getId(),
                        v.getVendorName(),
                        v.getDescription(),
                        v.getPhone(),
                        v.getAddress(),
                        v.getIsActive(),
                        v.getImageUrl() // ✅ tambahkan imageUrl
                ));
    }

    // Tambah vendor
    public VendorDTO createVendor(Vendor vendor) {
        Vendor saved = vendorRepository.save(vendor);
        return new VendorDTO(
                saved.getId(),
                saved.getVendorName(),
                saved.getDescription(),
                saved.getPhone(),
                saved.getAddress(),
                saved.getIsActive(),
                saved.getImageUrl() // ✅ tambahkan imageUrl
        );
    }

    // Update vendor
    public Optional<VendorDTO> updateVendor(Long id, Vendor vendorDetails) {
        return vendorRepository.findById(id).map(v -> {
            v.setVendorName(vendorDetails.getVendorName());
            v.setDescription(vendorDetails.getDescription());
            v.setPhone(vendorDetails.getPhone());
            v.setAddress(vendorDetails.getAddress());
            v.setIsActive(vendorDetails.getIsActive());
            v.setImageUrl(vendorDetails.getImageUrl()); // ✅ tambahkan imageUrl
            Vendor updated = vendorRepository.save(v);
            return new VendorDTO(
                    updated.getId(),
                    updated.getVendorName(),
                    updated.getDescription(),
                    updated.getPhone(),
                    updated.getAddress(),
                    updated.getIsActive(),
                    updated.getImageUrl() // ✅ tambahkan imageUrl
            );
        });
    }

    // Hapus vendor
    public boolean deleteVendor(Long id) {
        return vendorRepository.findById(id).map(v -> {
            vendorRepository.delete(v);
            return true;
        }).orElse(false);
    }
}
