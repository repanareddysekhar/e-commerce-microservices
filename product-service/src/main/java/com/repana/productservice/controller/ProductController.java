package com.repana.productservice.controller;

import com.repana.common.dto.ApiOutput;
import com.repana.productservice.dto.ProductDto;
import com.repana.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product-service/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiOutput<?>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @PutMapping("/{id}/update-product-quantity")
    public ResponseEntity<?> updateProductQuantity(@PathVariable UUID id, @RequestBody Integer quantity) {
        return ResponseEntity.ok(productService.updateProductQuantity(id, quantity));
    }
}
