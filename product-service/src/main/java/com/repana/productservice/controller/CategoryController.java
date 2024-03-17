package com.repana.productservice.controller;

import com.repana.common.dto.ApiOutput;
import com.repana.productservice.dto.CategoryDto;
import com.repana.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product-service/categoruy")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiOutput<?>> getAllCategory() {
        return ResponseEntity.ok(new ApiOutput<>(categoryService.getAllCategory()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiOutput<?>> getCategoryById(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiOutput<>(categoryService.getCategoryById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiOutput<?>> addCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(new ApiOutput<>(categoryService.addCategory(categoryDto)));
    }

    @PutMapping
    public ResponseEntity<ApiOutput<?>> updateCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(new ApiOutput<>(categoryService.updateCategory(categoryDto)));
    }
}
