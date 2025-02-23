package com.example.hexagonal.application.port.out;

import com.example.hexagonal.domain.aggregate.User;

public interface GetUserByNamePort {
    User getUser(String username);
}
