package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderNumber(String orderNumber);

    List<Order> findByCustomerNameContainingIgnoreCase(String customerName);

    List<Order> findByStatus(OrderStatus status);

    List<Order> findByOrderNumberContainingIgnoreCaseOrCustomerNameContainingIgnoreCaseOrProductContainingIgnoreCase(
            String orderNumber, String customerName, String product);
}
