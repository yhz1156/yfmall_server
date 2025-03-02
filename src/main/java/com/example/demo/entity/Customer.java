package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)  // 移除 nullable = false
    private String email;

    private String phone;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private java.util.List<Order> orders;

    @Column(name = "identity")
    private String identity;

    public static final String IDENTITY_ADMIN = "ADMIN";
    public static final String IDENTITY_CUSTOMER = "CUSTOMER";

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        if (identity != null) {
            identity = identity.toUpperCase();
            if (!identity.equals(IDENTITY_ADMIN) && !identity.equals(IDENTITY_CUSTOMER)) {
                throw new IllegalArgumentException("Invalid identity: " + identity);
            }
            this.identity = identity;
        }
    }
}