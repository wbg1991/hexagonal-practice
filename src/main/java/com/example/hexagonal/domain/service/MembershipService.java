package com.example.hexagonal.domain.service;

import com.example.hexagonal.domain.aggregate.User;
import com.example.hexagonal.domain.enums.MembershipLevel;

public class MembershipService {
    public static User determineMembership(User user, long totalAmount) {
        if (totalAmount >= 10_000_000) {
            return user.withMembershipLevel(MembershipLevel.PLATINUM);
        }

        if (totalAmount >= 5_000_000) {
            return user.withMembershipLevel(MembershipLevel.GOLD);
        }

        if (totalAmount >= 1_000_000) {
            return user.withMembershipLevel(MembershipLevel.SILVER);
        }

        return user.withMembershipLevel(MembershipLevel.BRONZE);
    }
}
