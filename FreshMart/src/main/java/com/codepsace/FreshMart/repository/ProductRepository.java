package com.codepsace.FreshMart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codepsace.FreshMart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
