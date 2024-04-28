package com.repana.productservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repana.common.dto.ApiError;
import com.repana.common.dto.ApiOutput;
import com.repana.common.enums.Errors;
import com.repana.common.exception.ApiErrorException;
import com.repana.productservice.dto.ProductDto;
import com.repana.productservice.entity.Product;
import com.repana.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper mapper;

    public ApiOutput<List<ProductDto>> getAllProducts() {
        return new ApiOutput<>(mapper.convertValue(productRepository.getAllProducts(),
                new TypeReference<List<ProductDto>>() {
        }));
    }

    public ApiOutput<?> getProductById(UUID id) {
        Optional<Product> productOptional = productRepository.findByIdAndIsDeleted(id, false);
        if (productOptional.isEmpty()) {
            return new ApiOutput<>(new ApiError(HttpStatus.NOT_FOUND,
                    Errors.PR_01.getMsg(),
                    new ApiErrorException(Errors.PR_01.getMsg(), HttpStatus.NOT_FOUND)));
        }
        return new ApiOutput<>(mapper.convertValue(productOptional.get(), ProductDto.class));
    }

    private Product save(Product product) {
        return productRepository.save(product);
    }

    public ApiOutput<?> addProduct(ProductDto productDto) {
        Product product = mapper.convertValue(productDto, Product.class);
        product = save(product);
        return new ApiOutput<>(mapper.convertValue(product, ProductDto.class));
    }

    public ApiOutput<?> updateProduct(ProductDto productDto) {
        Product product = mapper.convertValue(productDto, Product.class);
        product = save(product);
        return new ApiOutput<>(mapper.convertValue(product, ProductDto.class));
    }

    public ApiOutput<?> updateProductQuantity(UUID id, Integer quantity) {
        Optional<Product> productOp = productRepository.findByIdAndIsDeleted(id, false);
        if (productOp.isEmpty()) {
            return new ApiOutput<>(new ApiError(HttpStatus.NOT_FOUND,
                    Errors.PR_01.getMsg(),
                    new ApiErrorException(Errors.PR_01.getMsg(), HttpStatus.BAD_REQUEST)));
        }
        Product product = productOp.get();
        product.setQuantity(quantity);
        save(product);

        return new ApiOutput<>(mapper.convertValue(product, ProductDto.class));
    }
}
