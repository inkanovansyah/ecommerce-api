package com.ecommerce.ecommerce_api.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class CreateOrderRequest {

    @NotNull(message = "User ID tidak boleh kosong")
    private Long userId;

    @NotNull(message = "Vendor ID tidak boleh kosong")
    private Long vendorId;

    @NotBlank(message = "Order ID wajib diisi")
    @Size(max = 50, message = "Order ID maksimal 50 karakter")
    private String orderId;

    @Size(max = 255, message = "Catatan maksimal 255 karakter")
    private String customerNotes;

    @NotBlank(message = "Alamat pengiriman wajib diisi")
    private String deliveryAddress;

    @NotNull(message = "Items tidak boleh kosong")
    @Size(min = 1, message = "Minimal 1 item")
    private List<OrderItemDTO> items;

    @NotNull(message = "Payment tidak boleh kosong")
    private PaymentDTO payment;
}