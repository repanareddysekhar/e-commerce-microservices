package com.repana.productservice.dto;

import lombok.Data;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class BaseDtoUUID {
    private UUID id;
    private Boolean isDeleted = false;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
}
