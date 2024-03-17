package com.repana.productservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.repana.productservice.dto.CategoryDto;
import com.repana.productservice.entity.Category;
import com.repana.productservice.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ObjectMapper mapper;

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = mapper.convertValue(categoryDto, Category.class);
        category = save(category);
        return mapper.convertValue(category, CategoryDto.class);
    }

    public CategoryDto updateCategory(CategoryDto categoryDto) {
        Category category = mapper.convertValue(categoryDto, Category.class);
        category = save(category);
        return mapper.convertValue(category, CategoryDto.class);
    }

    private Category save(Category category) {
        return categoryRepository.save(category);
    }

    public CategoryDto getCategoryById(UUID id) {
        return mapper.convertValue(categoryRepository.findByIdAndIsDeleted(id, false), CategoryDto.class);
    }

    public List<CategoryDto> getAllCategory() {
        return mapper.convertValue(categoryRepository.getAll(),
                new TypeReference<List<CategoryDto>>() {});
    }
}
