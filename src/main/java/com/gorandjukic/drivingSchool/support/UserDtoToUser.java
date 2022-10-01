package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.model.User;
import com.gorandjukic.drivingSchool.service.UserService;
import com.gorandjukic.drivingSchool.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDto, User> {

    @Autowired
    private UserService userService;

    @Override
    public User convert(UserDto source) {
        User user = null;
        if (source.getId() != null) {
            user = userService.one(source.getId()).get();
        }
        if (user == null) {
            user = new User();
        }
        user.setUsername(source.getUsername());

        return user;
    }
}
