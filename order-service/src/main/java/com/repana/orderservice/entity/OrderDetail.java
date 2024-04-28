package com.repana.orderservice.entity;

import com.repana.common.entity.BaseEntityUUID;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Table
@Entity
@Getter
@Setter
public class OrderDetail extends BaseEntityUUID {

    @Column
    @NonNull
    private UUID userId;

    @Column
    @NonNull
    private Double totalPrice;
}
