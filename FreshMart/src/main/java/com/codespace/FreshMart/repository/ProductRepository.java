package com.codespace.FreshMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codespace.FreshMart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
