package com.fallon.sneakerapp.controllers;

import com.fallon.sneakerapp.dtos.LoginDTO;
import com.fallon.sneakerapp.dtos.RegisterDTO;
import com.fallon.sneakerapp.exceptions.InvalidCredentialsException;
import com.fallon.sneakerapp.exceptions.InvalidUserException;
import com.fallon.sneakerapp.exceptions.UserNameTakenException;
import com.fallon.sneakerapp.pojos.User;
import com.fallon.sneakerapp.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class  UserController {

    private UserServices userServices;
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    public void registerUser(HttpServletRequest request) throws IOException, SQLException, UserNameTakenException {
        ObjectMapper objectMapper = new ObjectMapper();
        RegisterDTO registerDTO = objectMapper.readValue(request.getInputStream(), RegisterDTO.class);
        userServices.registerUser(new User(registerDTO));
    }

    //TODO
    //Map data request data to a User object
    public String loginUser(HttpServletRequest request) throws IOException, SQLException, InvalidCredentialsException, InvalidUserException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginDTO loginDTO = objectMapper.readValue(request.getInputStream(), LoginDTO.class);
        User loggedInUser = userServices.login(new User(loginDTO));
        return new Gson().toJson(loggedInUser);

    }

}
