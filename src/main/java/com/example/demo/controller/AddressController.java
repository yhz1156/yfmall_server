package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerAddresses(@PathVariable Long customerId) {
        try {
            List<Address> addresses = addressService.getAddressesByCustomerId(customerId);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "查询成功");
            response.put("addresses", addresses);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
        try {
            // 根据 customerId 设置 customer
            if (address.getCustomerId() != null) {
                Customer customer = new Customer();
                customer.setId(address.getCustomerId());
                address.setCustomer(customer);
            }
            
            Address newAddress = addressService.createAddress(address);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "创建成功");
            response.put("address", newAddress);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        try {
            Address updatedAddress = addressService.updateAddress(id, address);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "更新成功");
            response.put("address", updatedAddress);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long id) {
        try {
            addressService.deleteAddress(id);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "删除成功");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
