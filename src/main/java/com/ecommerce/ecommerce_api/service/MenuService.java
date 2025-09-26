package com.ecommerce.ecommerce_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce_api.dto.MenuDTO;
import com.ecommerce.ecommerce_api.model.Menu;
import com.ecommerce.ecommerce_api.repository.MenuRepository;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Ambil semua menu
    public Page<MenuDTO> getAllMenus(Pageable pageable) {
        return menuRepository.findAll(pageable).map(this::convertToDTO);
    }

    // Ambil menu berdasarkan category
    public Page<MenuDTO> getMenusByCategory(String category, Pageable pageable) {
        return menuRepository.findByCategory(category, pageable).map(this::convertToDTO);
    }
    // Ambil menu berdasarkan price

    public Page<MenuDTO> getMenusByPriceRange(Double minPrice, Double maxPrice, Pageable pageable) {
        return menuRepository.findByPriceBetween(minPrice, maxPrice, pageable).map(this::convertToDTO);
    }

    private MenuDTO convertToDTO(Menu menu) {
        return new MenuDTO(
                menu.getId(),
                menu.getMenuName(),
                menu.getDescription(),
                menu.getPrice(),
                menu.getIsActive(),
                menu.getImageUrl(),
                menu.getCategory());
    }
}
