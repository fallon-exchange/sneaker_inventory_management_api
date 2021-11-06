package com.fallon.sneakerapp.controllers;

import com.fallon.sneakerapp.dtos.RegisterDTO;
import com.fallon.sneakerapp.exceptions.UserNameTakenException;
import com.fallon.sneakerapp.pojos.User;
import com.fallon.sneakerapp.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
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

}
