package com.codepsace.FreshMart.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class RegisterProductRequest {

    @NotBlank(message = "Product Name cannot be blank")
    @Size(max = 255, message = "Product name cannot be greater than 255 characters")
    @NotEmpty
    private String productName;

    @Positive(message = "Price cannot be negative or zero")
    private Double price;

    public RegisterProductRequest() {
    }

    public RegisterProductRequest(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
