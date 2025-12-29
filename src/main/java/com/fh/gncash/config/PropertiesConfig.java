package com.fh.gncash.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "jwt")
@Validated
public class PropertiesConfig {

    @NotBlank
    private String key;

    @NotNull
    private Long tokenDuration;

    public String getJwtKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getJwtTokenDuration() {
        return tokenDuration;
    }

    public void setTokenDuration(Long tokenDuration) {
        this.tokenDuration = tokenDuration;
    }
}
