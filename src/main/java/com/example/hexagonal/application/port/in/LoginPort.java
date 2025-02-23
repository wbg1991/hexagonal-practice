package com.example.hexagonal.application.port.in;

import com.example.hexagonal.framework.adapter.in.dto.LoginDTO;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;

public interface LoginPort {
    UserReadDTO login(LoginDTO loginRequestDTO);
}
