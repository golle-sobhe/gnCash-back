package com.fh.gncash.dao.service;

import com.fh.gncash.dao.entity.UserEntity;
import com.fh.gncash.dao.repository.UserJpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    public UserLoginService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        UserEntity userEntity = userJpaRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with phone: " + phoneNumber));
        return new org.springframework.security.core.userdetails.User(userEntity.getPhoneNumber(),
                userEntity.getPassword(), getGrantedAuthorities(userEntity.getRole().getRole()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }
}
