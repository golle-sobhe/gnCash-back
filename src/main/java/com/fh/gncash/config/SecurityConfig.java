package com.fh.gncash.config;

import com.fh.gncash.dao.service.UserLoginService;
import com.fh.gncash.model.RoleType;
import com.nimbusds.jose.jwk.source.ImmutableSecret;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(PropertiesConfig.class)
public class SecurityConfig {

    private final PropertiesConfig propertiesConfig;

    private final UserLoginService userLoginService;

    public SecurityConfig(UserLoginService userLoginService, PropertiesConfig propertiesConfig) {
        this.userLoginService = userLoginService;
        this.propertiesConfig = propertiesConfig;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    // /auth/login requires Basic Authentication to get a JWT token
                    auth.requestMatchers("/auth/login").authenticated();
                    auth.requestMatchers("/seller/**").hasRole(RoleType.Seller.getRole());
                    auth.requestMatchers("/admin/**").hasRole(RoleType.Admin.getRole());
                    auth.requestMatchers("/super/**").hasRole(RoleType.Super.getRole());
                    auth.requestMatchers("/regular/**").hasRole(RoleType.Regular.getRole());
                    auth.anyRequest().authenticated();
                })
                .httpBasic(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
            throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http
                .getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userLoginService).passwordEncoder(bCryptPasswordEncoder);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        return new NimbusJwtEncoder(new ImmutableSecret<>(this.propertiesConfig.getJwtKey().getBytes()));
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        byte[] keyBytes = this.propertiesConfig.getJwtKey().getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
    }
}
