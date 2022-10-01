package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.enumerations.Role;
import com.gorandjukic.drivingSchool.model.User;
import com.gorandjukic.drivingSchool.repository.UserRepository;
import com.gorandjukic.drivingSchool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> all(int page) {
        return userRepository.findAll(PageRequest.of(page, 2));
    }

    @Override
    public Optional<User> one(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
