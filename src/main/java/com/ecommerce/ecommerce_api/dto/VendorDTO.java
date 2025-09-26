package com.ecommerce.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorDTO {
    private Long id;
    private String vendorName;
    private String description;
    private String phone;
    private String address;
    private Boolean isActive;
    private String imageUrl; // ✅ tambah 1 baris ini saja
}
