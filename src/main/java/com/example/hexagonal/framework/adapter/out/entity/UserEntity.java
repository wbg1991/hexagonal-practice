package com.example.hexagonal.framework.adapter.out.entity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class UserEntity {
    private UUID id;
    private String username;
    private String password;
    private String address;
    private String details;
    private String zipcode;
    private String email;
    private String membershipLevel;
    private Boolean isApproved;
}
