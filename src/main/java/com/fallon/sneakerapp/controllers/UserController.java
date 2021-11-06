package com.fallon.sneakerapp.controllers;

import com.fallon.sneakerapp.services.UserServices;

import javax.servlet.http.HttpServletRequest;

public class UserController {

    private UserServices userServices;
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    public void registerUser(HttpServletRequest httpServletRequest) {

    }

}
