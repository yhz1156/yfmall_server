package com.example.demo.service.impl;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Address> getAddressesByCustomerId(Long customerId) {
        // 使用新的方法名
        return addressRepository.findByCustomer_Id(customerId);
        // 或者使用显式查询方法
        // return addressRepository.findAddressesByCustomerId(customerId);
    }

    @Override
    public Address createAddress(Address address) {
        try {
            // 验证必填字段
            if (address.getRecipientName() == null || address.getRecipientName().trim().isEmpty()) {
                throw new IllegalArgumentException("收件人姓名不能为空");
            }
            if (address.getPhone() == null || address.getPhone().trim().isEmpty()) {
                throw new IllegalArgumentException("联系电话不能为空");
            }
            if (address.getAddress() == null || address.getAddress().trim().isEmpty()) {
                throw new IllegalArgumentException("收货地址不能为空");
            }
            
            // 验证并设置客户信息
            if (address.getCustomer() == null || address.getCustomer().getId() == null) {
                throw new IllegalArgumentException("客户ID不能为空");
            }
            
            Customer customer = customerRepository.findById(address.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("客户不存在"));
            address.setCustomer(customer);
            
            return addressRepository.save(address);
        } catch (Exception e) {
            throw new RuntimeException("创建地址失败: " + e.getMessage());
        }
    }

    @Override
    public Address updateAddress(Long id, Address addressUpdate) {
        Address address = addressRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("地址不存在"));
        
        address.setRecipientName(addressUpdate.getRecipientName());
        address.setPhone(addressUpdate.getPhone());
        address.setAddress(addressUpdate.getAddress());
        
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("地址不存在");
        }
        addressRepository.deleteById(id);
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("地址不存在"));
    }
}
