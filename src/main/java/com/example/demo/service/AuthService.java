package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public Customer login(LoginRequest loginRequest) {
        return customerRepository.findByPhone(loginRequest.getPhone())
                .filter(customer -> customer.getPassword().equals(loginRequest.getPassword()))
                .orElse(null);
    }

    public Customer register(RegisterRequest request) {
        // 检查手机号是否已存在
        if (customerRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new RuntimeException("该手机号已被注册");
        }

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setPhone(request.getPhone());
        customer.setPassword(request.getPassword()); // 实际应用中应该加密
        customer.setIdentity(Customer.IDENTITY_CUSTOMER); // 设置默认身份为CUSTOMER
        
        return customerRepository.save(customer);
    }
}