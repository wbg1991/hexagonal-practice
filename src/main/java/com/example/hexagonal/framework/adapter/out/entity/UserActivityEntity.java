package com.example.hexagonal.framework.adapter.out.entity;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
public class UserActivityEntity {
    UUID userId;
    long purchaseAmount;
    OffsetDateTime createdAt;
}
