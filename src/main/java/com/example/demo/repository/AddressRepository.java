package com.example.demo.repository;

import com.example.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // 修改查询方法名以匹配实体关系
    List<Address> findByCustomer_Id(Long customerId);
    
    // 或者使用显式查询
    @Query("SELECT a FROM Address a WHERE a.customer.id = :customerId")
    List<Address> findAddressesByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT a FROM Address a WHERE a.id = :id")
    Optional<Address> findAddressById(@Param("id") Long id);
}
