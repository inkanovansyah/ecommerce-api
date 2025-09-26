package com.ecommerce.ecommerce_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** Name of the vendor. */
    private String vendorName;
    /** A short description of the vendor or its services/products. */
    private String description;
    /** Contact phone number of the vendor. */
    private String phone;
    /** Physical address of the vendor. */
    private String address;

    @Column(nullable = false)
    private Boolean isActive = true; // 1 aktif, 0 tidak aktif
    @Column(name = "image_url")
    private String imageUrl; // <-- ini tambahan baru
}
