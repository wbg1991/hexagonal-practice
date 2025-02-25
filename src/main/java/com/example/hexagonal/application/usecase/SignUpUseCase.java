package com.example.hexagonal.application.usecase;

import com.example.hexagonal.application.port.in.SignUpPort;
import com.example.hexagonal.application.port.out.UserRepositoryPort;
import com.example.hexagonal.domain.aggregate.User;
import com.example.hexagonal.domain.mapper.UserMapper;
import com.example.hexagonal.framework.adapter.in.dto.SignUpDTO;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SignUpUseCase implements SignUpPort {
    private final UserRepositoryPort userRepositoryPort;
    private final UserMapper userMapper;

    @Override
    public UserReadDTO execute(SignUpDTO signUpDTO) {
        if (userRepositoryPort.checkDuplicationUsername(signUpDTO.username()) ) {
            throw new RuntimeException("Exist User");
        }

        var user = User.createUser(signUpDTO.username(), signUpDTO.password(), signUpDTO.email());

        return userMapper.toReadDTO(userRepositoryPort.saveUser(userMapper.toEntity(user)));
    }
}
