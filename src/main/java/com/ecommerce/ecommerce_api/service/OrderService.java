package com.ecommerce.ecommerce_api.service;

import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce_api.dto.CreateOrderRequest;
import com.ecommerce.ecommerce_api.exception.BusinessException;
import com.ecommerce.ecommerce_api.model.Order;
import com.ecommerce.ecommerce_api.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    public Order createOrder(CreateOrderRequest request) {
        try {
            // Validasi tambahan
            validateOrder(request);

            // Convert items dan payment ke JSON
            String itemsJson = objectMapper.writeValueAsString(request.getItems());
            String paymentJson = objectMapper.writeValueAsString(request.getPayment());

            Order order = Order.builder()
                    .userId(request.getUserId())
                    .vendorId(request.getVendorId())
                    .orderId(request.getOrderId())
                    .customerNotes(request.getCustomerNotes())
                    .deliveryAddress(request.getDeliveryAddress())
                    .items(itemsJson)
                    .payment(paymentJson)
                    .build();

            return orderRepository.save(order);
        } catch (JsonProcessingException e) {
            throw new BusinessException("Gagal memproses data order", e);
        }
    }

    private void validateOrder(CreateOrderRequest request) {
        // Validasi order ID uniqueness
        if (orderRepository.existsByOrderId(request.getOrderId())) {
            throw new BusinessException("Order ID sudah digunakan");
        }

        // Validasi total amount consistency
        Integer calculatedTotal = request.getItems().stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();

        if (!calculatedTotal.equals(request.getPayment().getTotalAmount())) {
            throw new BusinessException("Total amount tidak sesuai dengan jumlah item");
        }

        // Validasi status pembayaran
        if (!isValidPaymentStatus(request.getPayment().getStatus())) {
            throw new BusinessException(
                    "Status pembayaran tidak valid. Gunakan: pending, paid, failed, atau refunded");
        }

        // Validasi metode pembayaran
        if (!isValidPaymentMethod(request.getPayment().getMethod())) {
            throw new BusinessException(
                    "Metode pembayaran tidak valid. Gunakan: transfer, cash, atau credit_card");
        }
    }

    private boolean isValidPaymentStatus(String status) {
        return status != null &&
                (status.equals("pending") || status.equals("paid") ||
                        status.equals("failed") || status.equals("refunded"));
    }

    private boolean isValidPaymentMethod(String method) {
        return method != null &&
                (method.equals("transfer") || method.equals("cash") ||
                        method.equals("credit_card"));
    }
}