package com.fallon.sneakerapp;

import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.dtos.RegisterDTO;
import com.fallon.sneakerapp.pojos.User;
import com.fallon.sneakerapp.services.UserServices;
import com.fallon.sneakerapp.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    /**
     * Using Main for testing
     * @param args
     */
    public static void main(String[] args) {

        try(Connection conn = ConnectionFactory.getInstance ().getConnection()){
            UserServices userServices = new UserServices(new UserDao(conn));
            RegisterDTO registerDTO = new RegisterDTO();
            registerDTO.setUsername("JaneSmith");
            registerDTO.setPassword("password");
            System.out.println(userServices.registerUser(new User(registerDTO)));
        }catch (Exception throwables){
            throwables.printStackTrace();
        }

    }
}
