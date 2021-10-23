package com.fallon.sneakerapp;

import com.fallon.sneakerapp.daos.UserDao;
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
            System.out.println(userServices.registerUser(new User("hulk","IAMANGRY")));
        }catch (Exception throwables){
            throwables.printStackTrace();
        }

    }
}
