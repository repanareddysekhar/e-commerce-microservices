package com.repana.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Getter
    @Setter
    @CreatedDate
    @Column(name = "createdat", nullable = false, updatable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("UTC"));

    @Getter
    @Setter
    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "modifiedat", nullable = false)
    private ZonedDateTime modifiedAt = ZonedDateTime.now(ZoneId.of("UTC"));

}
