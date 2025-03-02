package com.example.demo.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Data
@Entity
@Table(name = "orders")
@ToString(exclude = {"orderItems", "customer"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_ORDER_CUSTOMER"))
    @JsonIgnoreProperties("orders")
    private Customer customer;

    @Transient
    private Long customerId;

    @PostLoad
    private void loadCustomerId() {
        if (customer != null) {
            this.customerId = customer.getId();
        }
    }

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrderItem> orderItems = new ArrayList<>();  // 初始化为空列表

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column(name = "address_id")
    private Long addressId;

    @Transient
    private Map<String, String> addressInfo;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Map<String, String> getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(Map<String, String> addressInfo) {
        this.addressInfo = addressInfo;
    }

    public static final List<String> VALID_STATUSES = Arrays.asList(
        "PENDING", "PROCESSING", "COMPLETED", "CANCELLED", "SHIPPED", "REFUNDING", "REFUNDED"
    );

    public void setStatus(String status) {
        if (status != null) {
            status = status.toUpperCase();
            if (!VALID_STATUSES.contains(status)) {
                throw new IllegalArgumentException("无效的订单状态: " + status);
            }
            this.status = status;
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // 添加工具方法处理双向关系
    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
        item.setOrder(this);
    }

    // 确保customer属性的JSON序列化处理
    @JsonProperty("customer")
    public Map<String, Object> getCustomerDetails() {
        if (customer != null) {
            Map<String, Object> customerMap = new HashMap<>();
            customerMap.put("id", customer.getId());
            customerMap.put("name", customer.getName());
            return customerMap;
        }
        return null;
    }

    // 添加获取简化订单项信息的方法
    @JsonProperty("items")
    public List<Map<String, Object>> getOrderItemsDetails() {
        if (orderItems == null) return new ArrayList<>();
        return orderItems.stream().map(item -> {
            Map<String, Object> itemMap = new HashMap<>();
            itemMap.put("id", item.getId());
            itemMap.put("quantity", item.getQuantity());
            itemMap.put("price", item.getPrice());

            Map<String, Object> productMap = new HashMap<>();
            productMap.put("id", item.getProduct().getId());
            productMap.put("name", item.getProduct().getName());
            productMap.put("imageUrl", item.getProduct().getImageUrl() != null ? item.getProduct().getImageUrl() : "");
            
            itemMap.put("product", productMap);
            return itemMap;
        }).collect(Collectors.toList());
    }

    // 移除原有的 getter 方法
    @JsonIgnore
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    // 移除原来的 Address 实体关联
    // @ManyToOne
    // @JoinColumn(name = "address_id")
    // private Address address;
}