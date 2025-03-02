package com.example.demo.entity;


import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
@JsonIgnoreProperties(ignoreUnknown = true)  // 添加此注解以忽略未知字段
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    // 添加 customerId 属性用于接收前端数据
    @Transient
    private Long customerId;

    @PostLoad
    private void loadCustomerId() {
        if (customer != null) {
            this.customerId = customer.getId();
        }
    }

    // 添加设置 customer 的便捷方法
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
