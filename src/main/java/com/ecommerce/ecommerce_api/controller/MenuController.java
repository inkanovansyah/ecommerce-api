package com.ecommerce.ecommerce_api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce_api.dto.ApiResponse;
import com.ecommerce.ecommerce_api.dto.MenuDTO;
import com.ecommerce.ecommerce_api.service.MenuService;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ApiResponse<Page<MenuDTO>> getMenus(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            Pageable pageable) {
        try {
            Page<MenuDTO> menus;

            // Filter harga saja
            if (minPrice != null && maxPrice != null) {
                menus = menuService.getMenusByPriceRange(minPrice, maxPrice, pageable);
            }
            // Filter kategori saja
            else if (category != null) {
                menus = menuService.getMenusByCategory(category, pageable);
            }
            // Semua menu
            else {
                menus = menuService.getAllMenus(pageable);
            }

            return new ApiResponse<>(true, "Berhasil ambil data menus", menus);
        } catch (Exception e) {
            // log error ke console
            e.printStackTrace();
            // kirim error response ke client
            return new ApiResponse<>(false, "Terjadi kesalahan pada server: " + e.getMessage(), null);
        }
    }
}
