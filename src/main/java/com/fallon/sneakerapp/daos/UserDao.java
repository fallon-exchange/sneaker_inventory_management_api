package com.fallon.sneakerapp.daos;

import com.fallon.sneakerapp.pojos.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection){
        this.connection = connection;
    }

    public User save(User newUser) throws SQLException{
        String sqlInsertUser = "insert into users(username, password) values(?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sqlInsertUser, new String[]{"user_id"});
        pstmt.setString(1, newUser.getUsername());
        pstmt.setString(2, newUser.getPassword());

        int rowsInserted = pstmt.executeUpdate();

        if(rowsInserted != 0){
            ResultSet resultSet = pstmt.getGeneratedKeys();
            while (resultSet.next()){
                newUser.setUserId(resultSet.getInt("user_id"));
            }
        }

        return newUser;
    }

    public boolean selectUsername(User user) throws SQLException {
        String sqlSelectUser = "select * from users where username = ?";
        PreparedStatement pstmt = connection.prepareStatement(sqlSelectUser);
        pstmt.setString(1,user.getUsername());

        ResultSet resultSet = pstmt.executeQuery();

        if(resultSet.next()){
            return true;
        }

        return false;
    }
}
