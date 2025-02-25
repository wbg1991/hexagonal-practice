package com.example.hexagonal.framework.adapter.out;

import com.example.hexagonal.application.port.out.*;
import com.example.hexagonal.domain.aggregate.User;
import com.example.hexagonal.framework.adapter.out.entity.UserEntity;
import com.example.hexagonal.framework.adapter.out.mapper.UserEntityMapper;
import com.example.hexagonal.framework.adapter.out.repository.UserActivityRepository;
import com.example.hexagonal.framework.adapter.out.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class UserDBAdapter  implements UserRepositoryPort {
    private final UserRepository userRepository;
    private final UserActivityRepository userActivityRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User getUser(String username) {
       return userEntityMapper.toDomain(userRepository.getUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User Not Found")));
    }

    @Override
    public User saveUser(UserEntity entity) {
        return userEntityMapper.toDomain(userRepository.saveUser(entity));
    }

    @Override
    public boolean checkDuplicationUsername(String username) {
        return userRepository.getUserByUsername(username).isPresent();
    }

    @Override
    public long getTotalPurchaseAmount(UUID userId) {
        return userActivityRepository.getTotalPurchaseAmountPort(userId);
    }
}
