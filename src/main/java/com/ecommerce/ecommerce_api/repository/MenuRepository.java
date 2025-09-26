package com.ecommerce.ecommerce_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce_api.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // Filter berdasarkan category (otomatis query method)
    Page<Menu> findByCategory(String category, Pageable pageable);

    // Filter harga saja
    Page<Menu> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
}
