package com.fh.gncash.dao.service;

import com.fh.gncash.dao.entity.UserEntity;
import com.fh.gncash.dao.mapper.UserMapper;
import com.fh.gncash.dao.repository.UserJpaRepository;
import com.fh.gncash.model.RoleType;
import com.fh.gncash.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    private final UserJpaRepository userJpaRepository;

    public UserDataService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    public List<User> getAll() {
        return userJpaRepository.findAll()
                .stream()
                .map(UserMapper::toModel)
                .toList();
    }

    public User getById(String id) {
        return userJpaRepository.findById(id)
                .map(UserMapper::toModel)
                .orElse(null);
    }

    public User create(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toModel(userJpaRepository.save(entity));
    }

    public User update(String id, User user) {
        UserEntity entity = userJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        entity.setPhoneNumber(user.phoneNumber());
        entity.setFirstName(user.firstName());
        entity.setLastName(user.lastName());
        entity.setIdType(user.idType());
        entity.setRole(user.role());
        return UserMapper.toModel(userJpaRepository.save(entity));
    }

    public void delete(String id) {
        userJpaRepository.deleteById(id);
    }

    public List<User> getByRole(RoleType role) {
        return userJpaRepository.findByRole(role)
                .stream()
                .map(UserMapper::toModel)
                .toList();
    }

}
