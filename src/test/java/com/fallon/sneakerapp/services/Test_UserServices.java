package com.fallon.sneakerapp.services;

import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.exceptions.InvalidCredentialsException;
import com.fallon.sneakerapp.exceptions.InvalidUserException;
import com.fallon.sneakerapp.exceptions.UserNameTakenException;
import com.fallon.sneakerapp.pojos.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class Test_UserServices {
    UserDao mockUserDao = mock(UserDao.class);
    UserServices sut;


    @Before
    public void setUp(){
        sut = new UserServices(mockUserDao);
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test(expected = UserNameTakenException.class)
    public void test_registerUserWithUserNameTake() throws SQLException, UserNameTakenException {
        User testUser = new User();
        when(mockUserDao.userExists(any())).thenReturn(Boolean.TRUE);
        sut.registerUser(testUser);
    }

    @Test
    public void test_registerUserWithValidUser() throws SQLException, UserNameTakenException {
        User testUser = new User(1, "testUser", "testPassword");
        when(mockUserDao.userExists(any())).thenReturn(Boolean.FALSE);
        when(mockUserDao.save(any())).thenReturn(testUser);



        assertEquals(testUser, sut.registerUser(new User()));

        verify(mockUserDao, times(1)).userExists(any());
        verify(mockUserDao, times(1)).save(any());
    }

    @Test
    public void test_loginValidUser() throws SQLException, InvalidCredentialsException, InvalidUserException {
        //testing variables
        User testUser = new User(1, "testUser", "testPassword");

        //setting values of testing variable
        when(mockUserDao.userExists(any())).thenReturn(Boolean.TRUE);
        when(mockUserDao.getUserByUsernameAndPassword(any())).thenReturn(testUser);

        //calls login method and
        User actualResult = sut.login(null);

        assertEquals(testUser, actualResult);
    }

    @Test (expected = InvalidUserException.class)
    public void test_userDoesntExist() throws SQLException, InvalidCredentialsException, InvalidUserException {
        User testUser = new User("testUser", "testUser");

        when(mockUserDao.userExists(any())).thenReturn(Boolean.FALSE);

        sut.login(testUser);
    }

    @Test (expected = InvalidCredentialsException.class)
    public  void test_invalidPassword() throws SQLException, InvalidCredentialsException, InvalidUserException {
        User testUser = new User("testUser", "testUser");

        when(mockUserDao.userExists(any())).thenReturn(Boolean.TRUE);
        when(mockUserDao.getUserByUsernameAndPassword(any())).thenReturn(null);

        sut.login(testUser);
    }
}
