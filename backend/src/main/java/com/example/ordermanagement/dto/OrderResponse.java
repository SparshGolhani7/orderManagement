package com.example.ordermanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {

    private Long id;
    private String orderNumber;
    private String customerName;
    private String customerEmail;
    private String product;
    private Integer quantity;
    private Double unitPrice;
    private Double totalAmount;
    private String status;
    private String orderDate;
    private String deliveryDate;
    private String shippingAddress;
}
