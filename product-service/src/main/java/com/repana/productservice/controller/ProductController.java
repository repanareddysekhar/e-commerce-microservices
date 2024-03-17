package com.repana.productservice.controller;

import com.repana.common.dto.ApiOutput;
import com.repana.productservice.dto.CategoryDto;
import com.repana.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product-service/category")
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping
//    private ResponseEntity<ApiOutput<?>> getAllProducts() {
//        return ResponseEntity.ok(new ApiOutput<>(productService.getAllCategory()));
//    }
//
//    @GetMapping("/{id}")
//    private ResponseEntity<ApiOutput<?>> getProductById(@PathVariable UUID id) {
//        return ResponseEntity.ok(new ApiOutput<>(productService.getCategoryById(id)));
//    }
//
//    @PostMapping
//    private ResponseEntity<ApiOutput<?>> addCategory(@RequestBody CategoryDto categoryDto) {
//        return ResponseEntity.ok(new ApiOutput<>(productService.addCategory(categoryDto)));
//    }
//
//    @PutMapping
//    private ResponseEntity<ApiOutput<?>> updateCategory(@RequestBody CategoryDto categoryDto) {
//        return ResponseEntity.ok(new ApiOutput<>(productService.updateCategory(categoryDto)));
//    }
}
