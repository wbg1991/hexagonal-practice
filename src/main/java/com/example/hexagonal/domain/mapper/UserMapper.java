package com.example.hexagonal.domain.mapper;

import com.example.hexagonal.domain.aggregate.User;
import com.example.hexagonal.framework.adapter.in.dto.UserReadDTO;
import com.example.hexagonal.framework.adapter.out.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @InheritInverseConfiguration
    UserReadDTO toReadDTO(User user);

    default UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .address(user.getAddress().address())
                .details(user.getAddress().details())
                .zipcode(user.getAddress().zipcode())
                .email(user.getEmail())
                .membershipLevel(user.getMembershipLevel().name())
                .isApproved(user.getIsApproved())
                .build();
    }
}
