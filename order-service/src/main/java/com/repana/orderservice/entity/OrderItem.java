package com.repana.orderservice.entity;

import com.repana.common.entity.BaseEntityLongId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table
@Entity
@Getter
@Setter
public class OrderItem extends BaseEntityLongId {
    @Column
    private UUID orderId;
    @Column
    private UUID productId;
    @Column
    private int quantity;
}
