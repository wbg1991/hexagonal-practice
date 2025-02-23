package com.example.hexagonal.framework.adapter.out.repository;

import com.example.hexagonal.framework.adapter.out.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Repository
public class UserRepository {
    private final Set<UserEntity> users;

    UserRepository() {
        users = new HashSet<>();

        users.add(UserEntity.builder()
                .id(UUID.fromString("f4c39304-c0ef-451d-b419-addcf81c2f93"))
                .username("kimara")
                .password("1234")
                .email("kimara@gmail.com")
                .zipcode("06133")
                .address("부산광역시 해운대구 센텀중앙로 45")
                .details("7층 705호")
                .membershipLevel("GOLD")
                .isApproved(true)
                .build());
    }

    public Optional<UserEntity> getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public UserEntity saveUser(UserEntity user) {
        users.add(user);
        log.info("USERS: {}", users);
        return user;
    }
}
