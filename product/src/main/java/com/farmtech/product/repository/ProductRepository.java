package com.farmtech.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmtech.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    boolean existsByName(String name);

    Optional<Product> findByName(String name);
}
