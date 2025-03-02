package com.example.demo.service;

import com.example.demo.entity.Address;
import java.util.List;

public interface AddressService {
    List<Address> getAddressesByCustomerId(Long customerId);
    Address createAddress(Address address);
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id);
    Address getAddressById(Long id);
}
