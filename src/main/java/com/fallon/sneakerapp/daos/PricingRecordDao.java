package com.fallon.sneakerapp.daos;

import com.fallon.sneakerapp.pojos.PricingRecord;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PricingRecordDao {
    private Connection connection;

    public PricingRecordDao(Connection connection){
        this.connection = connection;
    }

    public void save(PricingRecord newPricingRecord) throws SQLException{
        String sqlInsertPricingRecord = "insert into pricing_records( "+
        "sneaker_id, date_of_record, goat_lowest_price,"+
        "goat_highest_price, stockx_lowest_price, stockx_highest_price,"+
        "flight_club_lowest_price, stadium_goods_lowest_price, retail_price,"+
        "goat_insta_ship_price) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sqlInsertPricingRecord, new String[]{"pricing_record_id"});
        pstmt.setInt(1, newPricingRecord.getSneakerId());
        pstmt.setDate(2, Date.valueOf(newPricingRecord.getDateOfRecord()));
        pstmt.setDouble(3,newPricingRecord.getGoatLowestPrice());
        pstmt.setDouble(4,newPricingRecord.getGoatHighestPrice());
        pstmt.setDouble(5,newPricingRecord.getStockXLowestPrice());
        pstmt.setDouble(6,newPricingRecord.getStockXHighestPrice());
        pstmt.setDouble(7,newPricingRecord.getFlightClubLowestPrice());
        pstmt.setDouble(8,newPricingRecord.getStadiumGoodsLowestPrice());
        pstmt.setDouble(9,newPricingRecord.getRetailPrice());
        pstmt.setDouble(10,newPricingRecord.getGoatInstaShipPrice());

        pstmt.execute();
    }




}
