package com.example.hexagonal.framework.adapter.out.repository;

import com.example.hexagonal.framework.adapter.out.entity.UserActivityEntity;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Repository
public class UserActivityRepository {
    private final Set<UserActivityEntity> activities;

    public UserActivityRepository() {
        activities = new HashSet<>();
        ZoneOffset offset = ZoneOffset.ofHours(9);

        activities.add(UserActivityEntity.builder()
                .userId(UUID.fromString("f4c39304-c0ef-451d-b419-addcf81c2f93"))
                .purchaseAmount(240_000)
                .createdAt(OffsetDateTime.of(2023, 7, 15, 16, 32, 30, 0, offset))
                .build());

        activities.add(UserActivityEntity.builder()
                .userId(UUID.fromString("f4c39304-c0ef-451d-b419-addcf81c2f93"))
                .purchaseAmount(290_000)
                .createdAt(OffsetDateTime.of(2023, 8, 11, 16, 23, 22, 0, offset))
                .build());

        activities.add(UserActivityEntity.builder()
                .userId(UUID.fromString("f4c39304-c0ef-451d-b419-addcf81c2f93"))
                .purchaseAmount(240_000)
                .createdAt(OffsetDateTime.of(2023, 10, 12, 10, 12, 5, 0, offset))
                .build());

        activities.add(UserActivityEntity.builder()
                .userId(UUID.fromString("f4c39304-c0ef-451d-b419-addcf81c2f93"))
                .purchaseAmount(170_000)
                .createdAt(OffsetDateTime.of(2024, 3, 5, 13, 32, 33, 0, offset))
                .build());

        activities.add(UserActivityEntity.builder()
                .userId(UUID.fromString("f4c39304-c0ef-451d-b419-addcf81c2f93"))
                .purchaseAmount(50_000)
                .createdAt(OffsetDateTime.of(2024, 5, 7, 11, 44, 50, 0, offset))
                .build());
    }

    public long getTotalPurchaseAmountPort(UUID userId) {
        return activities.stream()
                .filter(activity -> activity.getUserId().equals(userId))
                .mapToLong(UserActivityEntity::getPurchaseAmount)
                .sum();
    }
}
