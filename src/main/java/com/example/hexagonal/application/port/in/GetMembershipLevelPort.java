package com.example.hexagonal.application.port.in;

import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;

public interface GetMembershipLevelPort {
    UserReadDTO getMembershipLevel(String username);
}
