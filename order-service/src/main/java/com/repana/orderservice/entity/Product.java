package com.repana.orderservice.entity;

import com.repana.common.entity.BaseEntityUUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Table
@Entity
@Getter
@Setter
public class Product extends BaseEntityUUID {
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @Column
    private int quantity;
    @Column
    private UUID category;
}
