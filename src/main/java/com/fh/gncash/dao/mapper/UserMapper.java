package com.fh.gncash.dao.mapper;

import com.fh.gncash.dao.entity.UserEntity;
import com.fh.gncash.model.User;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(user.id());
        entity.setPhoneNumber(user.phoneNumber());
        entity.setPassword(user.password());
        entity.setFirstName(user.firstName());
        entity.setLastName(user.lastName());
        entity.setIdType(user.idType());
        entity.setRole(user.role());
        return entity;
    }

    public static User toModel(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        return new User(
                entity.getId(),
                entity.getPhoneNumber(),
                entity.getPassword(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getIdType(),
                entity.getRole());
    }
}
