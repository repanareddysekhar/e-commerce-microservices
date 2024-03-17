package com.repana.productservice.controller;

import com.repana.common.dto.ApiOutput;
import com.repana.productservice.dto.CategoryDto;
import com.repana.productservice.dto.ProductDto;
import com.repana.productservice.service.ProductService;
import jakarta.ws.rs.PUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product-service/category")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiOutput<?>> getAllProducts() {
        return ResponseEntity.ok(new ApiOutput<>(productService.getAllProducts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiOutput<?>> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiOutput<>(productService.getProductById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiOutput<?>> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(new ApiOutput<>(productService.addProduct(productDto)));
    }

    @PutMapping
    public ResponseEntity<ApiOutput<?>> updateProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(new ApiOutput<>(productService.updateProduct(productDto)));
    }

    @PutMapping("/{id}/update-product-quantity")
    public ResponseEntity<ApiOutput<?>> updateProductQuantity(@PathVariable UUID id, @RequestBody Integer quantity) {
        return ResponseEntity.ok(new ApiOutput<>(productService.updateProductQuantity(id, quantity)));
    }
}
