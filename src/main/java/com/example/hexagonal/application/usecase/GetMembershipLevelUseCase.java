package com.example.hexagonal.application.usecase;

import com.example.hexagonal.application.port.in.GetMembershipLevelPort;
import com.example.hexagonal.application.port.out.UserRepositoryPort;
import com.example.hexagonal.domain.mapper.UserMapper;
import com.example.hexagonal.domain.service.MembershipService;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMembershipLevelUseCase implements GetMembershipLevelPort {
    private final UserRepositoryPort userRepositoryPort;
    private final UserMapper userMapper;

    @Override
    public UserReadDTO execute(String username) {
        var user = userRepositoryPort.getUser(username);
        var amount = userRepositoryPort.getTotalPurchaseAmount(user.getId());

        return userMapper.toReadDTO(MembershipService.determineMembership(user, amount));
    }
}
