package com.example.demo.service;

import com.example.demo.entity.Order;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long id);
    List<Order> getOrdersByCustomerId(Long customerId);
    List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    List<Order> getOrdersByCustomerAndDateRange(Long customerId, LocalDateTime startDate, LocalDateTime endDate);
    Order createOrder(Order order);
    void deleteOrder(Long id);
    
    /**
     * 创建订单并更新库存
     * @param order 订单信息
     * @return 创建的订单
     * @throws IllegalArgumentException 当库存不足时抛出
     * @throws RuntimeException 当订单创建失败时抛出
     */
    Order createOrderAndUpdateStock(Order order);
    
    /**
     * 修改订单状态
     * @param orderId 订单ID
     * @param newStatus 新状态
     * @return 更新后的订单
     * @throws RuntimeException 当订单不存在时抛出
     */
    Order updateOrderStatus(Long orderId, String newStatus);
}