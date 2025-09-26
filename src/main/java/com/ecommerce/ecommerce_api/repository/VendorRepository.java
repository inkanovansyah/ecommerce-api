package com.ecommerce.ecommerce_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce_api.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
