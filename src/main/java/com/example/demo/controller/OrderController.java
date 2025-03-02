package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderItem;
import com.example.demo.entity.Product;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        System.out.println("Getting all orders");
        try {
            List<Order> orders = orderService.getAllOrders();
            List<Map<String, Object>> orderList = new ArrayList<>();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            for (Order order : orders) {
                Map<String, Object> orderMap = new HashMap<>();
                orderMap.put("id", order.getId());
                orderMap.put("customerId", order.getCustomerId());
                // 格式化日期
                orderMap.put("orderDate", order.getOrderDate().format(formatter));
                orderMap.put("totalAmount", order.getTotalAmount());
                orderMap.put("status", order.getStatus());
                orderMap.put("note", order.getNote());
                orderMap.put("addressId", order.getAddressId());
                orderMap.put("addressInfo", order.getAddressInfo());  // 添加地址信息
                System.out.println(orderMap.get("addressInfo"));
                // 处理订单项
                List<Map<String, Object>> items = new ArrayList<>();
                for (OrderItem item : order.getOrderItems()) {
                    Map<String, Object> itemMap = new HashMap<>();
                    itemMap.put("id", item.getId());
                    itemMap.put("quantity", item.getQuantity());
                    itemMap.put("price", item.getPrice());

                    // 添加商品信息
                    Product product = item.getProduct();
                    if (product != null) {
                        itemMap.put("product", new HashMap<String, Object>() {{
                            put("id", product.getId());
                            put("name", product.getName());
                            put("imageUrl", product.getImageUrl() != null ? product.getImageUrl() : "");
                        }});
                    }

                    items.add(itemMap);
                }
                orderMap.put("items", items);
                orderList.add(orderMap);
            }

            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("message", "查询成功");
                put("orders", orderList);
            }});

        } catch (Exception e) {
            // 添加更详细的错误日志
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new HashMap<String, Object>() {{
                put("message", "查询失败: " + e.getMessage());
            }});
        }
    }

    @GetMapping("/my-orders/{customerId}")
    public ResponseEntity<?> getMyOrders(@PathVariable Long customerId) {
        try {
            List<Order> orders = orderService.getOrdersByCustomerId(customerId);
            System.out.println(orders);
            List<Map<String, Object>> orderList = new ArrayList<>();
            for (Order order : orders) {
                Map<String, Object> orderMap = new HashMap<>();
                orderMap.put("id", order.getId());
                orderMap.put("orderDate", order.getOrderDate());
                orderMap.put("totalAmount", order.getTotalAmount());
                orderMap.put("status", order.getStatus());
                orderMap.put("note", order.getNote());
                orderMap.put("addressId", order.getAddressId());
                orderMap.put("addressInfo", order.getAddressInfo());  // 添加地址信息
                System.out.println(orderMap.get("addressInfo"));
                // 处理订单项
                List<Map<String, Object>> items = new ArrayList<>();
                for (OrderItem item : order.getOrderItems()) {
                    Map<String, Object> itemMap = new HashMap<>();
                    itemMap.put("id", item.getId());
                    itemMap.put("quantity", item.getQuantity());
                    itemMap.put("price", item.getPrice());
                    
                    // 添加商品信息
                    Product product = item.getProduct();
                    if (product != null) {
                        itemMap.put("product", new HashMap<String, Object>() {{
                            put("id", product.getId());
                            put("name", product.getName());
                            put("imageUrl", product.getImageUrl() != null ? product.getImageUrl() : "");
                        }});
                    }
                    
                    items.add(itemMap);
                }
                orderMap.put("items", items);
                orderList.add(orderMap);
            }

            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("message", "查询成功");
                put("orders", orderList);
            }});
            
        } catch (Exception e) {
            // 添加更详细的错误日志
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new HashMap<String, Object>() {{
                put("message", "查询失败: " + e.getMessage());
            }});
        }
    }

    @GetMapping("/date-range")
    public List<Order> getOrdersByDateRange(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        return orderService.getOrdersByDateRange(startDate, endDate);
    }

    @GetMapping("/customer/{customerId}/date-range")
    public List<Order> getOrdersByCustomerAndDateRange(
            @PathVariable Long customerId,
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        return orderService.getOrdersByCustomerAndDateRange(customerId, startDate, endDate);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, Object> request) {
        try {
            Order order = new Order();
            order.setCustomerId(Long.valueOf(request.get("customerId").toString()));
            order.setAddressId(Long.valueOf(request.get("addressId").toString()));
            order.setNote((String) request.get("note"));
            order.setTotalAmount(new BigDecimal(request.get("totalAmount").toString()));
            
            List<Map<String, Object>> itemsList = (List<Map<String, Object>>) request.get("items");
            
            for (Map<String, Object> item : itemsList) {
                OrderItem orderItem = new OrderItem();
                Product product = new Product();
                // 修改这里使用 productId 而不是 id
                product.setId(Long.valueOf(item.get("productId").toString()));
                orderItem.setProduct(product);
                // 从请求中获取数量
                orderItem.setQuantity(Integer.valueOf(item.get("quantity").toString()));
                orderItem.setPrice(new BigDecimal(item.get("price").toString()));
                order.addOrderItem(orderItem);
            }
            
            Order newOrder = orderService.createOrder(order);
            
            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("message", "下单成功");
                put("orderId", newOrder.getId());
                put("totalAmount", newOrder.getTotalAmount());
                put("status", newOrder.getStatus());
                put("orderDate", newOrder.getOrderDate());
            }});
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new HashMap<String, Object>() {{
                put("message", "下单失败: " + e.getMessage());
            }});
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateOrderStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        try {
            String status = request.get("status");
            if (status == null) {
                return ResponseEntity.badRequest().body(new HashMap<String, Object>() {{
                    put("message", "状态参数不能为空");
                }});
            }
            Order updatedOrder = orderService.updateOrderStatus(id, status);
            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("message", "订单状态更新成功");
                put("order", updatedOrder);
            }});
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new HashMap<String, Object>() {{
                put("message", e.getMessage());
            }});
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseEntity.ok(new HashMap<String, Object>() {{
                put("message", "订单删除成功");
            }});
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new HashMap<String, Object>() {{
                put("message", e.getMessage());
            }});
        }
    }
}