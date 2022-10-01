package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.domain.User;
import com.gorandjukic.drivingSchool.web.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        UserDto dto = new UserDto();

        dto.setId(source.getId());
        dto.setUsername(source.getUsername());

        return dto;
    }

    public List<UserDto> convert(List<User> source) {
        List<UserDto> dtos = new ArrayList<>();

        for (User u : source) {
            dtos.add(convert(u));
        }
        return dtos;
    }

}
