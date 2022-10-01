package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> all();

    Page<User> all(int page);

    Optional<User> one(Long id);

    User save(User user);

    void delete(Long id);
}
