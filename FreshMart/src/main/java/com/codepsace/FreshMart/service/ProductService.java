package com.codepsace.FreshMart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codepsace.FreshMart.model.Product;
import com.codepsace.FreshMart.repository.ProductRepository;

@Service
public class ProductService {
    /*
     * findAll
     * findById
     * save(Product product)
     * update
     * delete(Long id)
     */

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product product) {
        Product existing = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product Not found"));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());

        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
