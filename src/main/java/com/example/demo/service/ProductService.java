package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    List<Product> searchProductsByName(String name);
    List<Product> findProductsLowInStock(Integer threshold);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    boolean updateStock(Long id, Integer quantity);
}