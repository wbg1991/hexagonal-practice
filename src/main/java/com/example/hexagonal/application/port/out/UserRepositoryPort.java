package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.aggregate.User;
import com.example.hexagonal.framework.adapter.out.entity.UserEntity;

import java.util.UUID;

public interface UserRepositoryPort {
    boolean checkDuplicationUsername(String username);
    long getTotalPurchaseAmount(UUID userId);
    User getUser(String username);
    User saveUser(UserEntity entity);
}
