package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderResponse;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.OrderStatus;
import com.example.ordermanagement.exception.OrderNotFoundException;
import com.example.ordermanagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        return mapToResponse(order);
    }

    public OrderResponse getOrderByOrderNumber(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with order number: " + orderNumber));
        return mapToResponse(order);
    }

    public List<OrderResponse> searchOrders(String keyword) {
        List<Order> orders = orderRepository
                .findByOrderNumberContainingIgnoreCaseOrCustomerNameContainingIgnoreCaseOrProductContainingIgnoreCase(
                        keyword, keyword, keyword);
        return orders.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public List<OrderResponse> getOrdersByStatus(OrderStatus status) {
        List<Order> orders = orderRepository.findByStatus(status);
        return orders.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // Convert Entity to DTO
    private OrderResponse mapToResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .orderNumber(order.getOrderNumber())
                .customerName(order.getCustomerName())
                .customerEmail(order.getCustomerEmail())
                .product(order.getProduct())
                .quantity(order.getQuantity())
                .unitPrice(order.getUnitPrice().doubleValue())
                .totalAmount(order.getTotalAmount().doubleValue())
                .status(order.getStatus().name())
                .orderDate(order.getOrderDate() != null ? order.getOrderDate().toString() : null)
                .deliveryDate(order.getDeliveryDate() != null ? order.getDeliveryDate().toString() : null)
                .shippingAddress(order.getShippingAddress())
                .build();
    }
}
