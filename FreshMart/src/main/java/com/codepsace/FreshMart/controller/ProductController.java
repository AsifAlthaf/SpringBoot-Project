package com.codepsace.FreshMart.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.Map;
import java.util.List;
import com.codepsace.FreshMart.dtos.ProductDto;
import com.codepsace.FreshMart.dtos.RegisterProductRequest;
import com.codepsace.FreshMart.model.Product;
import com.codepsace.FreshMart.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @GetMapping
    // public List<Product> getAll() {
    // return productService.findAll();
    // }
    @GetMapping
    public List<ProductDto> getAll() {

        return productService.findAll()
                .stream()
                .map(product -> new ProductDto(
                        product.getId(),
                        product.getName(),
                        product.getPrice()))
                .toList();
    }

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public Product create(Product product) {
    // return productService.save(product);
    // }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody RegisterProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());

        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
