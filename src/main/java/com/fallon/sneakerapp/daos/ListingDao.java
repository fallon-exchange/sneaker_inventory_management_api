package com.fallon.sneakerapp.daos;

import com.fallon.sneakerapp.pojos.Listing;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListingDao {
    //TODO
    private Connection connection;

    public ListingDao(Connection connection) {
        this.connection = connection;
    }

    public  void  save(Listing newListing) throws SQLException{
        String sqlInsertListing = "insert into listings(" +
        "listing_id, sneaker_id, listing_service, listing_price" +
        "values(?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sqlInsertListing, new String[]{"listing_id"});
        pstmt.setInt(1,newListing.getListingId());
        pstmt.setInt(2, newListing.getSneakerId());
        pstmt.setDate(3, Date.valueOf(newListing.getListingService()));
        pstmt.setDouble(4, newListing.getListingId());
    }


}
