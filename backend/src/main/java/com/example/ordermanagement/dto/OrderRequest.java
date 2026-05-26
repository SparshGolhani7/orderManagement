package com.example.ordermanagement.dto;

import lombok.Data;

@Data
public class OrderRequest {

    private String orderNumber;
    private String customerName;
    private String customerEmail;
    private String product;
    private Integer quantity;
    private Double unitPrice;
    private String status;
    private String shippingAddress;
}
