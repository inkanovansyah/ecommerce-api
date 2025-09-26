package com.ecommerce.ecommerce_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** The name of the menu item. */
    private String menuName;
    /** A brief description of the menu item. */
    private String description;
    /** The price of the menu item. */
    private Double price;
    /** Indicates whether the menu item is currently active/available. */
    private Boolean isActive;
    /** The URL of the image representing the menu item. */
    private String imageUrl;
    /** The category this menu item belongs to (e.g., Drinks, Snacks). */
    private String category;
}
