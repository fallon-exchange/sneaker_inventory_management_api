package com.fallon.sneakerapp;

import com.fallon.sneakerapp.daos.StyleDao;
import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.dtos.RegisterDTO;
import com.fallon.sneakerapp.pojos.Style;

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

            Style style = new Style("testStyle5", "test", "test", "test");
            StyleDao styleDao = new StyleDao(conn);
            styleDao.save(style);

        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }
}
