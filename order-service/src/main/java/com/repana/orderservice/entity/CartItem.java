package com.repana.orderservice.entity;

import com.repana.common.entity.BaseEntityLongId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table
@Entity
@Setter
@Getter
public class CartItem extends BaseEntityLongId {
    @Column
    private UUID cartId;
    @Column
    private UUID productId;
    @Column
    private int quantity;
}
