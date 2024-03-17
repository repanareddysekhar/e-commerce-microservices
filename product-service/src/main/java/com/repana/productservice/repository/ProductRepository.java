package com.repana.productservice.repository;

import com.repana.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("select p from Product p where p.isDeleted = false")
    List<Product> getAllProducts();

    Product findByIdAndIsDeleted(UUID id, boolean isDeleted);
}
