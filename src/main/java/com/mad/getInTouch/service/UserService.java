package com.mad.getInTouch.service;

import com.mad.getInTouch.entity.User;
import com.mad.getInTouch.request.UserLoginRequest;

public interface UserService {

    User create(User user);

    User userLogin(UserLoginRequest request);
}
