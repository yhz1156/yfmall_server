package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.enums.ProductStatus;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Order> getAllOrders() {
        System.out.println(123);
        //return orderRepository.findAll();
        List<Order> orders = orderRepository.findAll();
       // System.out.println("Found orders: " + orders.size());  // 调试日志
        // 预加载每个订单的地址信息
        for (Order order : orders) {
            if (order.getAddressId() != null) {
                try {
                    // 重要：显式加载地址信息
                    Optional<Address> addressOpt = addressRepository.findAddressById(order.getAddressId());
                    if (addressOpt.isPresent()) {
                        Address address = addressOpt.get();
                        Map<String, String> addressInfo = new HashMap<>();
                        addressInfo.put("recipientName", address.getRecipientName());
                        addressInfo.put("phone", address.getPhone());
                        addressInfo.put("address", address.getAddress());
                        addressInfo.put("id", String.valueOf(address.getId()));

                        order.setAddressInfo(addressInfo);
                        System.out.println("Order " + order.getId() + " address loaded: " + addressInfo);  // 调试日志
                    } else {
                        System.out.println("Address not found for order " + order.getId());  // 调试日志
                    }
                } catch (Exception e) {
                    System.err.println("Failed to load address for order " + order.getId() + ": " + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                System.out.println("No address ID for order " + order.getId());  // 调试日志
            }
        }
        System.out.println(orders);
        return orders;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public List<Order> getOrdersByCustomerId(Long customerId) {
        try {
            if (!customerRepository.existsById(customerId)) {
                throw new RuntimeException("客户不存在");
            }
            
            List<Order> orders = orderRepository.findByCustomer_Id(customerId);
            System.out.println("Found orders: " + orders.size());  // 调试日志
            
            // 预加载每个订单的地址信息
            for (Order order : orders) {
                if (order.getAddressId() != null) {
                    try {
                        // 重要：显式加载地址信息
                        Optional<Address> addressOpt = addressRepository.findAddressById(order.getAddressId());
                        if (addressOpt.isPresent()) {
                            Address address = addressOpt.get();
                            Map<String, String> addressInfo = new HashMap<>();
                            addressInfo.put("recipientName", address.getRecipientName());
                            addressInfo.put("phone", address.getPhone());
                            addressInfo.put("address", address.getAddress());
                            addressInfo.put("id", String.valueOf(address.getId()));
                            
                            order.setAddressInfo(addressInfo);
                            System.out.println("Order " + order.getId() + " address loaded: " + addressInfo);  // 调试日志
                        } else {
                            System.out.println("Address not found for order " + order.getId());  // 调试日志
                        }
                    } catch (Exception e) {
                        System.err.println("Failed to load address for order " + order.getId() + ": " + e.getMessage());
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No address ID for order " + order.getId());  // 调试日志
                }
            }
            System.out.println(orders);
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取订单失败: " + e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByOrderDateBetween(startDate, endDate);
    }

    @Override
    public List<Order> getOrdersByCustomerAndDateRange(Long customerId, LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findByCustomer_IdAndOrderDateBetween(customerId, startDate, endDate);
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        System.out.println(order+"2");
        return createOrderAndUpdateStock(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("订单不存在"));
                
        // 只有未完成的订单（PENDING 或 PROCESSING 状态）删除时才需要恢复库存
        if ("PENDING".equals(order.getStatus()) || "PROCESSING".equals(order.getStatus())) {
            for (OrderItem item : order.getOrderItems()) {
                Product product = productRepository.findById(item.getProduct().getId())
                        .orElseThrow(() -> new RuntimeException("商品不存在"));
                        
                // 恢复库存
                product.setStock(product.getStock() + item.getQuantity());
                productRepository.save(product);
            }
        }
        
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Order createOrderAndUpdateStock(Order order) {
        // 验证基本信息
        if (order.getCustomerId() == null) {
            throw new IllegalArgumentException("客户ID不能为空");
        }
        if (order.getAddressId() == null) {
            throw new IllegalArgumentException("收货地址不能为空");
        }
        
        // 验证地址是否存在
        if (!addressRepository.existsById(order.getAddressId())) {
            throw new RuntimeException("收货地址不存在");
        }

        // 设置客户信息
        Customer customer = customerRepository.findById(order.getCustomerId())
                .orElseThrow(() -> new RuntimeException("客户不存在"));
        order.setCustomer(customer);

        // 验证并设置地址信息
        Address address = addressRepository.findById(order.getAddressId())
                .orElseThrow(() -> new RuntimeException("收货地址不存在"));
        order.setAddressId(order.getAddressId());

        // 处理订单项和库存
        for (OrderItem item : order.getOrderItems()) {
            // 检查商品状态
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("商品不存在"));
            System.out.println(product);
            
            if (!product.isAvailable()) {
                throw new IllegalArgumentException("商品 " + product.getName() + " 当前不可购买");
            }
            
            // 检查库存
            if (product.getStock() < item.getQuantity()) {
                throw new IllegalArgumentException("商品 " + product.getName() + " 库存不足");
            }

            // 更新库存
            product.setStock(product.getStock() - item.getQuantity());
            // 检查是否需要更新商品状态为缺货
            if (product.getStock() == 0) {
                product.setStatus(ProductStatus.OUT_OF_STOCK.getCode());
            }
            Product savedProduct = productRepository.save(product);
            if (savedProduct == null) {
                throw new RuntimeException("商品库存更新失败");
            }
            item.setOrder(order);
        }

        // 设置订单状态和时间
        order.setStatus("PENDING");
        order.setOrderDate(LocalDateTime.now());

        // 保存订单
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order updateOrderStatus(Long orderId, String newStatus) {
        if (newStatus == null || newStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("订单状态不能为空");
        }
        
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("订单不存在: " + orderId));
        
        try {
            order.setStatus(newStatus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("订单状态无效: " + e.getMessage());
        }
        
        return orderRepository.save(order);
    }
    
    private boolean isValidStatus(String status) {
        return Arrays.asList("PENDING", "PROCESSING", "COMPLETED", "CANCELLED")
                .contains(status.toUpperCase());
    }
}