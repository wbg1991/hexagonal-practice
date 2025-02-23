package com.example.hexagonal.domain.aggregate;

import com.example.hexagonal.domain.enums.MembershipLevel;
import com.example.hexagonal.domain.vo.Address;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.UUID;

@Builder
@With
@Value
public class User {
    UUID id;
    String username;
    String password;
    Address address;
    String email;
    MembershipLevel membershipLevel;
    Boolean isApproved;

    public static User createUser(String username, String password, String email) {
        return User.builder()
                .id(UUID.randomUUID())
                .username(username)
                .password(password)
                .email(email)
                .address(new Address("", "", ""))
                .membershipLevel(MembershipLevel.BRONZE)
                .isApproved(false)
                .build();
    }
}
