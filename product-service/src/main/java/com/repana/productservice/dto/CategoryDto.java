package com.repana.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto extends BaseDtoUUID{
    private String categoryName;
    private String description;
}
