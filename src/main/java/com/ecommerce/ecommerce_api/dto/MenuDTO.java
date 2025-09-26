package com.ecommerce.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    private Long id;
    private String menuName;
    private String description;
    private Double price;
    private Boolean isActive;
    private String imageUrl;
    private String category;
}
