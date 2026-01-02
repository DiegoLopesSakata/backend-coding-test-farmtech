package com.farmtech.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.farmtech.product.entity.Product;
import com.farmtech.product.exception.BusinessException;
import com.farmtech.product.exception.ResourceNotFoundException;
import com.farmtech.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {

        if (repository.existsByName(product.getName())) {
            throw new BusinessException("Product name already exists");
        }

        return repository.save(product);
    }

    public Product update(Long id, Product product) {

        Product existing = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        existing.setName(product.getName());
        existing.setStatus(product.getStatus());
        existing.setFarmer(product.getFarmer());

        return repository.save(existing);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}
