package com.repana.orderservice.entity;

import com.repana.common.entity.BaseEntityUUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table
@Entity
@Getter
@Setter
public class Cart extends BaseEntityUUID {
    @Column
    private UUID userId;

    @Column
    private Double totalPrice;
}
