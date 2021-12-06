package com.fallon.sneakerapp.daos;

import com.fallon.sneakerapp.pojos.Style;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StyleDao {
    private Connection connection;

    public StyleDao(Connection connection) {
        this.connection = connection;
    }


    public boolean styleExists(Style style) throws SQLException {
        String sqlSelectStyle = "select * from styles where style_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectStyle);
        preparedStatement.setString(1, style.getStyleId());

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            return true;
        }

        return false;
    }

    public void save(Style style) throws SQLException {
        String sqlInsertStyle = "insert into styles(style_id, style_name, type, sub_type) values(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertStyle);
        preparedStatement.setString(1, style.getStyleId());
        preparedStatement.setString(2, style.getStyleName());
        preparedStatement.setString(3, style.getType());
        preparedStatement.setString(4, style.getSubType());

        preparedStatement.execute();
    }
}
