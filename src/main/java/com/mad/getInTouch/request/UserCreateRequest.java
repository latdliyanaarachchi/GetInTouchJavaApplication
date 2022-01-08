package com.mad.getInTouch.request;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String email;

    private String name;

    private String password;
}
