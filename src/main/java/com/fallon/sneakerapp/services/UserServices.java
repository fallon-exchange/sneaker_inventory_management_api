package com.fallon.sneakerapp.services;

import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.pojos.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServices {
    private UserDao userDao;

    public UserServices(UserDao userDao){
        this.userDao = userDao;
    }

    public User registerUser(User newUser) throws Exception {
        if(userDao.selectUsername(newUser)){
            throw new Exception("Username taken");
        }

        User registeredUser = userDao.save(newUser);
        return registeredUser;
    }


}
