package com.repana.productservice.repository;

import com.repana.productservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByIdAndIsDeleted(UUID id, boolean isDeleted);

    @Query("select c from Category c where c.isDeleted = false")
    List<Category> getAll();
}
