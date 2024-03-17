package com.repana.productservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDto extends BaseDtoUUID{
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private UUID category;
}
