package com.fallon.sneakerapp;

import com.fallon.sneakerapp.daos.SneakerDao;
import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.dtos.RegisterDTO;
import com.fallon.sneakerapp.pojos.Sneaker;
import com.fallon.sneakerapp.pojos.User;
import com.fallon.sneakerapp.services.UserServices;
import com.fallon.sneakerapp.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Driver {
    /**
     * Using Main for testing
     * @param args
     */
    public static void main(String[] args) {

        try(Connection conn = ConnectionFactory.getInstance ().getConnection()){
            User user = new User("sfallon", "pa$$w0rd");
            UserDao userDao = new UserDao(conn);
            Sneaker sneaker = new Sneaker("GZ554", 10, 1, true, LocalDate.of(2021, 10,7), 60);
            System.out.println(userDao.login(user));

        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }
}
