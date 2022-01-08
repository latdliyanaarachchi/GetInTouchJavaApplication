package com.mad.getInTouch.service.impl;

import com.mad.getInTouch.entity.User;
import com.mad.getInTouch.repository.UserRepository;
import com.mad.getInTouch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);

    }
}
