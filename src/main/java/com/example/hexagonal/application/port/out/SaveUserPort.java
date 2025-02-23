package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.aggregate.User;
import com.example.hexagonal.framework.adapter.out.entity.UserEntity;

public interface SaveUserPort {
    User saveUser(UserEntity entity);
}
