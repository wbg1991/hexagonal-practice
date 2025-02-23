package com.example.hexagonal.framework.adapter.in;

import com.example.hexagonal.application.port.in.GetMembershipLevelPort;
import com.example.hexagonal.application.port.in.LoginPort;
import com.example.hexagonal.application.port.in.SignUpPort;
import com.example.hexagonal.framework.adapter.in.dto.LoginDTO;
import com.example.hexagonal.framework.adapter.in.dto.SignUpDTO;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthRestAdapter {
    private final LoginPort loginPort;
    private final SignUpPort signUpPort;
    private final GetMembershipLevelPort getMembershipLevelPort;

    @PostMapping("/login")
    public UserReadDTO login(@RequestBody LoginDTO loginDTO) {
        var userDTO = loginPort.login(loginDTO);

        log.info("USER DTO: {}", userDTO);

        return userDTO;
    }

    @PostMapping("/signup")
    public UserReadDTO signUp(@RequestBody SignUpDTO signUpDTO) {
        return signUpPort.signUp(signUpDTO);
    }

    @GetMapping("/membership/{username}")
    public UserReadDTO membership(@PathVariable String username) {
        return getMembershipLevelPort.getMembershipLevel(username);
    }
}
