package com.gorandjukic.drivingSchool.web.dto;

import com.gorandjukic.drivingSchool.enumerations.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserDto {

    @NotBlank
    private Long id;

    @NotEmpty
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
