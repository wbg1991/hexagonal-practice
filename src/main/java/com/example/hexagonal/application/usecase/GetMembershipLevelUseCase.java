package com.example.hexagonal.application.usecase;

import com.example.hexagonal.application.port.in.GetMembershipLevelPort;
import com.example.hexagonal.application.port.out.GetTotalPurchaseAmountPort;
import com.example.hexagonal.application.port.out.GetUserByNamePort;
import com.example.hexagonal.domain.mapper.UserMapper;
import com.example.hexagonal.domain.service.MembershipService;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMembershipLevelUseCase implements GetMembershipLevelPort {
    private final GetUserByNamePort getUserByNamePort;
    private final GetTotalPurchaseAmountPort getTotalPurchaseAmountPort;
    private final UserMapper userMapper;

    @Override
    public UserReadDTO getMembershipLevel(String username) {
        var user = getUserByNamePort.getUser(username);
        var amount = getTotalPurchaseAmountPort.getTotalPurchaseAmount(user.getId());

        return userMapper.toReadDTO(MembershipService.determineMembership(user, amount));
    }
}
