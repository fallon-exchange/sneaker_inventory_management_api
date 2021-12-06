package com.fallon.sneakerapp.services;

import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.exceptions.InvalidCredentialsException;
import com.fallon.sneakerapp.exceptions.InvalidUserException;
import com.fallon.sneakerapp.exceptions.UserNameTakenException;
import com.fallon.sneakerapp.pojos.User;

import java.sql.SQLException;

public class UserServices {
    private UserDao userDao;

    public UserServices(UserDao userDao){
        this.userDao = userDao;
    }

    public User registerUser(User newUser) throws UserNameTakenException, SQLException {
        if(userDao.userExists(newUser)){
            throw new UserNameTakenException();
        }

        User registeredUser = userDao.save(newUser);
        return registeredUser;
    }

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     * @throws InvalidUserException
     * @throws InvalidCredentialsException
     *
     */
    public User login(User user) throws SQLException, InvalidUserException, InvalidCredentialsException {
        if (!userDao.userExists(user)){
            throw new InvalidUserException();
        }

        user = userDao.getUserByUsernameAndPassword(user);

        if(user == null){
            throw new InvalidCredentialsException();
        }

        return user;
    }


}
