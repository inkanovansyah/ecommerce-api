package com.ecommerce.ecommerce_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class PaymentDTO {

    @NotBlank(message = "Metode pembayaran wajib diisi")
    private String method;

    @NotNull(message = "Total amount tidak boleh kosong")
    @Min(value = 0, message = "Total amount tidak boleh negatif")
    private Integer totalAmount;

    @NotBlank(message = "Status pembayaran wajib diisi")
    private String status;
}