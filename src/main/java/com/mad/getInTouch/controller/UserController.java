package com.mad.getInTouch.controller;

import com.mad.getInTouch.entity.User;
import com.mad.getInTouch.request.UserCreateRequest;
import com.mad.getInTouch.request.UserLoginRequest;
import com.mad.getInTouch.response.UserCreateResponse;
import com.mad.getInTouch.response.UserLoginResponse;
import com.mad.getInTouch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("${app.endpoint.userCreate}")
    public ResponseEntity<UserCreateResponse> create(@Validated @RequestBody UserCreateRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        User userDb = userService.create(user);
        UserCreateResponse response = new UserCreateResponse();
        response.setId(userDb.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("${app.endponit.userLogin}")
    public ResponseEntity<UserLoginResponse> login(@Validated @RequestBody UserLoginRequest request) {
        User userDb = userService.userLogin(request);
        UserLoginResponse response = new UserLoginResponse();
        if (userDb == null) {
            response.setId(null);
            response.setUserAvailable(false);
        } else {
            response.setId(userDb.getId());
            response.setUserAvailable(true);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
