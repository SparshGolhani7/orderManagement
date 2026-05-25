package com.example.ordermanagement.config;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.OrderStatus;
import com.example.ordermanagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) {
        if (orderRepository.count() == 0) {
            orderRepository.saveAll(Arrays.asList(
                Order.builder()
                    .orderNumber("ORD-2024-001")
                    .customerName("Rahul Sharma")
                    .customerEmail("rahul.sharma@email.com")
                    .product("Laptop - Dell Inspiron 15")
                    .quantity(1)
                    .unitPrice(new BigDecimal("72999.00"))
                    .totalAmount(new BigDecimal("72999.00"))
                    .status(OrderStatus.DELIVERED)
                    .orderDate(LocalDateTime.of(2024, 1, 15, 10, 30))
                    .deliveryDate(LocalDateTime.of(2024, 1, 22, 14, 0))
                    .shippingAddress("42, MG Road, Bangalore, Karnataka 560001")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-002")
                    .customerName("Priya Patel")
                    .customerEmail("priya.patel@email.com")
                    .product("Samsung Galaxy S24 Ultra")
                    .quantity(1)
                    .unitPrice(new BigDecimal("134999.00"))
                    .totalAmount(new BigDecimal("134999.00"))
                    .status(OrderStatus.SHIPPED)
                    .orderDate(LocalDateTime.of(2024, 2, 5, 9, 15))
                    .shippingAddress("18, Marine Drive, Mumbai, Maharashtra 400020")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-003")
                    .customerName("Amit Kumar")
                    .customerEmail("amit.kumar@email.com")
                    .product("Sony WH-1000XM5 Headphones")
                    .quantity(2)
                    .unitPrice(new BigDecimal("29990.00"))
                    .totalAmount(new BigDecimal("59980.00"))
                    .status(OrderStatus.PROCESSING)
                    .orderDate(LocalDateTime.of(2024, 3, 10, 16, 45))
                    .shippingAddress("7, Connaught Place, New Delhi 110001")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-004")
                    .customerName("Sneha Reddy")
                    .customerEmail("sneha.reddy@email.com")
                    .product("Apple MacBook Air M3")
                    .quantity(1)
                    .unitPrice(new BigDecimal("114900.00"))
                    .totalAmount(new BigDecimal("114900.00"))
                    .status(OrderStatus.CONFIRMED)
                    .orderDate(LocalDateTime.of(2024, 3, 20, 11, 0))
                    .shippingAddress("25, Jubilee Hills, Hyderabad, Telangana 500033")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-005")
                    .customerName("Vikram Singh")
                    .customerEmail("vikram.singh@email.com")
                    .product("LG 55-inch OLED TV")
                    .quantity(1)
                    .unitPrice(new BigDecimal("149990.00"))
                    .totalAmount(new BigDecimal("149990.00"))
                    .status(OrderStatus.PENDING)
                    .orderDate(LocalDateTime.of(2024, 4, 1, 8, 30))
                    .shippingAddress("12, Civil Lines, Jaipur, Rajasthan 302006")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-006")
                    .customerName("Ananya Gupta")
                    .customerEmail("ananya.gupta@email.com")
                    .product("iPad Pro 12.9 inch")
                    .quantity(1)
                    .unitPrice(new BigDecimal("112900.00"))
                    .totalAmount(new BigDecimal("112900.00"))
                    .status(OrderStatus.CANCELLED)
                    .orderDate(LocalDateTime.of(2024, 4, 12, 14, 20))
                    .shippingAddress("88, Park Street, Kolkata, West Bengal 700016")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-007")
                    .customerName("Rajesh Menon")
                    .customerEmail("rajesh.menon@email.com")
                    .product("Dyson V15 Vacuum Cleaner")
                    .quantity(1)
                    .unitPrice(new BigDecimal("62900.00"))
                    .totalAmount(new BigDecimal("62900.00"))
                    .status(OrderStatus.DELIVERED)
                    .orderDate(LocalDateTime.of(2024, 5, 3, 10, 0))
                    .deliveryDate(LocalDateTime.of(2024, 5, 8, 16, 30))
                    .shippingAddress("5, MG Road, Kochi, Kerala 682011")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-008")
                    .customerName("Deepa Nair")
                    .customerEmail("deepa.nair@email.com")
                    .product("Canon EOS R6 Camera")
                    .quantity(1)
                    .unitPrice(new BigDecimal("215990.00"))
                    .totalAmount(new BigDecimal("215990.00"))
                    .status(OrderStatus.SHIPPED)
                    .orderDate(LocalDateTime.of(2024, 5, 18, 12, 30))
                    .shippingAddress("33, Anna Nagar, Chennai, Tamil Nadu 600040")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-009")
                    .customerName("Karthik Iyer")
                    .customerEmail("karthik.iyer@email.com")
                    .product("Herman Miller Aeron Chair")
                    .quantity(2)
                    .unitPrice(new BigDecimal("89900.00"))
                    .totalAmount(new BigDecimal("179800.00"))
                    .status(OrderStatus.PROCESSING)
                    .orderDate(LocalDateTime.of(2024, 6, 2, 9, 45))
                    .shippingAddress("15, Koramangala, Bangalore, Karnataka 560034")
                    .build(),

                Order.builder()
                    .orderNumber("ORD-2024-010")
                    .customerName("Meera Joshi")
                    .customerEmail("meera.joshi@email.com")
                    .product("Bose SoundLink Speaker")
                    .quantity(3)
                    .unitPrice(new BigDecimal("19900.00"))
                    .totalAmount(new BigDecimal("59700.00"))
                    .status(OrderStatus.CONFIRMED)
                    .orderDate(LocalDateTime.of(2024, 6, 15, 15, 10))
                    .shippingAddress("9, FC Road, Pune, Maharashtra 411004")
                    .build()
            ));
        }
    }
}
