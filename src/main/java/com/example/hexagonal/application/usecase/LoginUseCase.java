package com.example.hexagonal.application.usecase;

import com.example.hexagonal.application.port.in.LoginPort;
import com.example.hexagonal.application.port.out.UserRepositoryPort;
import com.example.hexagonal.domain.mapper.UserMapper;
import com.example.hexagonal.framework.adapter.in.dto.LoginDTO;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginUseCase implements LoginPort {
    private final UserRepositoryPort userRepositoryPort;
    private final UserMapper userMapper;

    @Override
    public UserReadDTO execute(LoginDTO loginRequestDTO) {
        var user = userRepositoryPort.getUser(loginRequestDTO.username());

        log.info("USER: {}", user);

        if (!user.getPassword().equals(loginRequestDTO.password())) {
            throw new RuntimeException("Incorrect password");
        }

        if (!user.getIsApproved()) {
            throw new RuntimeException("Not Approved");
        }

        return userMapper.toReadDTO(user);
    }
}
