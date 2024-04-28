package com.repana.productservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repana.common.dto.ApiError;
import com.repana.common.dto.ApiOutput;
import com.repana.common.enums.Errors;
import com.repana.common.exception.ApiErrorException;
import com.repana.productservice.dto.CategoryDto;
import com.repana.productservice.entity.Category;
import com.repana.productservice.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ObjectMapper mapper;

    public ApiOutput<?> addCategory(CategoryDto categoryDto) {
        Category category = mapper.convertValue(categoryDto, Category.class);
        category = save(category);
        return new ApiOutput<>(mapper.convertValue(category, CategoryDto.class));
    }

    public ApiOutput<?> updateCategory(CategoryDto categoryDto) {
        Category category = mapper.convertValue(categoryDto, Category.class);
        category = save(category);
        return new ApiOutput<>(mapper.convertValue(category, CategoryDto.class));
    }

    private Category save(Category category) {
        return categoryRepository.save(category);
    }

    public ApiOutput<?> getCategoryById(UUID id) {
        Optional<Category> category = categoryRepository.findByIdAndIsDeleted(id, false);
        if (category.isEmpty()) {
            return new ApiOutput<>(new ApiError(HttpStatus.NOT_FOUND,
                    Errors.CAT_01.getMsg(),
                    new ApiErrorException(Errors.CAT_01.getMsg(), HttpStatus.NOT_FOUND)));
        }
        return new ApiOutput<>(mapper.convertValue(category, CategoryDto.class));
    }

    public ApiOutput<List<CategoryDto>> getAllCategory() {
        return new ApiOutput<>(mapper.convertValue(categoryRepository.getAll(), new TypeReference<List<CategoryDto>>() {
        }));
    }
}
