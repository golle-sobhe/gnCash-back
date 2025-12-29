package com.fh.gncash.dao.repository;

import com.fh.gncash.dao.entity.UserEntity;
import com.fh.gncash.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {

    List<UserEntity> findByRole(RoleType role);

    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
}
