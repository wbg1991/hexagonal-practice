package com.example.hexagonal.framework.adapter.out.mapper;

import com.example.hexagonal.domain.aggregate.User;
import com.example.hexagonal.domain.enums.MembershipLevel;
import com.example.hexagonal.domain.vo.Address;
import com.example.hexagonal.framework.adapter.out.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    default User toDomain(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .address(new Address(entity.getAddress(), entity.getDetails(), entity.getZipcode()))
                .email(entity.getEmail())
                .membershipLevel(MembershipLevel.valueOf(entity.getMembershipLevel()))
                .isApproved(entity.getIsApproved())
                .build();
    }
}
