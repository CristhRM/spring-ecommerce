package com.spring.ecommerce.service;

import com.spring.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Optional<Product> get(Integer id);
    void update(Product product);
    void delete(Integer id);
    List<Product> findAll();
}
