package com.fallon.sneakerapp.daos;

import com.fallon.sneakerapp.pojos.Sneaker;

import java.sql.*;

public class SneakerDao {
    private Connection connection;

    public SneakerDao(Connection connection){
        this.connection = connection;
    }

    public Sneaker save(Sneaker newSneaker) throws SQLException{
        String sqlInsertSneaker = "insert into sneakers(style_id, size, user_id, is_sold, date_bought, price_bought)"
        +  " values(?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sqlInsertSneaker, new String[]{"sneaker_id"});
        pstmt.setString(1, newSneaker.getStyleId());
        pstmt.setDouble(2, newSneaker.getSize());
        pstmt.setInt(3, newSneaker.getUserId());
        pstmt.setBoolean(4, newSneaker.isSold());
        pstmt.setDate(5, Date.valueOf(newSneaker.getDateBought()));
        pstmt.setDouble(6, newSneaker.getPriceBought());

        int rowsInserted = pstmt.executeUpdate();

        if(rowsInserted != 0){
            ResultSet resultSet = pstmt.getGeneratedKeys();
            while (resultSet.next()){
                newSneaker.setSneakerId(resultSet.getInt("sneaker_id"));
            }
        }

        return newSneaker;
    }
}
