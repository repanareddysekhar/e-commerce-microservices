package com.repana.orderservice.repository;

import com.repana.orderservice.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
    Optional<OrderDetail> findByIdAndIsDeleted(UUID id, boolean isDeleted);
}
