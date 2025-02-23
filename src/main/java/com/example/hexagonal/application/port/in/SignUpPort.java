package com.example.hexagonal.application.port.in;

import com.example.hexagonal.framework.adapter.in.dto.SignUpDTO;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;

public interface SignUpPort {
    UserReadDTO signUp(SignUpDTO signUpDTO);
}
