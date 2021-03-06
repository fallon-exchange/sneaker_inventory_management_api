package com.fallon.sneakerapp.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory;
    private Properties props = new Properties();

    static{
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace ();
        }

    }

    private ConnectionFactory(){
//        try{
//            props.load(new FileReader("src/main/resources/application.properties"));
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }

    public static ConnectionFactory getInstance(){
        if (connectionFactory == null){
            connectionFactory = new ConnectionFactory ();
        }

        return connectionFactory;
    }

    public Connection getConnection(){
        Connection conn = null;
        try{

            conn = DriverManager.getConnection (

                    System.getenv( "host-url"),
                    System.getenv( "username"),
                    System.getenv("password")

                    //props.getProperty ("host-url"),
                    //props.getProperty ("username"),
                    //props.getProperty ("password")
            );




        }catch(SQLException e){
            e.printStackTrace ();
        }
        return conn;
    }

}
