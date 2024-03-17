package com.repana.productservice.entity;

import com.repana.common.entity.BaseEntityUUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Entity
@Table
@Getter
@Service
public class Category extends BaseEntityUUID {
    @Column
    private String categoryName;
    @Column
    private String description;
}
