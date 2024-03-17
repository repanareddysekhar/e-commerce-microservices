package com.repana.productservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repana.common.dto.ApiError;
import com.repana.productservice.dto.CategoryDto;
import com.repana.productservice.dto.ProductDto;
import com.repana.productservice.entity.Product;
import com.repana.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper mapper;

    public List<ProductDto> getAllProducts() {
        return mapper.convertValue(productRepository.getAllProducts(),
                new TypeReference<List<ProductDto>>() {});
    }

    public ProductDto getProductById(UUID id) {
        return mapper.convertValue(productRepository.findByIdAndIsDeleted(id, false),
                ProductDto.class);
    }

    private Product save(Product product) {
        return productRepository.save(product);
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = mapper.convertValue(productDto, Product.class);
        product = save(product);
        return mapper.convertValue(product, ProductDto.class);
    }

    public ProductDto updateProduct(ProductDto productDto) {
        Product product = mapper.convertValue(productDto, Product.class);
        product = save(product);
        return mapper.convertValue(product, ProductDto.class);
    }

    public String updateProductQuantity(UUID id, Integer quantity) {
        Product product = productRepository.findByIdAndIsDeleted(id, false);
        if (ObjectUtils.isEmpty(product)) {
//            return new ApiError(HttpStatus.BAD_REQUEST);
        }
        product.setQuantity(quantity);
        save(product);
        return "Updated Product quantity successfully";
    }
}
