package com.fallon.sneakerapp;

import com.fallon.sneakerapp.daos.PricingRecordDao;
import com.fallon.sneakerapp.daos.SneakerDao;
import com.fallon.sneakerapp.daos.UserDao;
import com.fallon.sneakerapp.dtos.RegisterDTO;
import com.fallon.sneakerapp.pojos.PricingRecord;
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
            PricingRecord pricingRecord = new PricingRecord();
            pricingRecord.setSneakerId(1);
            pricingRecord.setDateOfRecord(LocalDate.of(2012,12,8));

            PricingRecordDao pricingRecordDao = new PricingRecordDao(conn);
            pricingRecordDao.save(pricingRecord);

        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }
}
