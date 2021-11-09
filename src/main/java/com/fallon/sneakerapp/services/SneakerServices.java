package com.fallon.sneakerapp.services;

import com.fallon.sneakerapp.daos.PricingRecordDao;
import com.fallon.sneakerapp.daos.SneakerDao;
import com.fallon.sneakerapp.daos.StyleDao;
import com.fallon.sneakerapp.pojos.PricingRecord;
import com.fallon.sneakerapp.pojos.Sneaker;
import com.fallon.sneakerapp.pojos.Style;

import java.sql.SQLException;

public class SneakerServices {
    private StyleDao styleDao;
    private SneakerDao sneakerDao;
    private PricingRecordDao pricingRecordDao;

    public SneakerServices(StyleDao styleDao, SneakerDao sneakerDao, PricingRecordDao pricingRecordDao){
        this.styleDao = styleDao;
        this.sneakerDao = sneakerDao;
        this.pricingRecordDao = pricingRecordDao;
    }

    public void save(int userId, Sneaker sneaker, Style style, PricingRecord pricingRecord) throws SQLException {
        if(!styleDao.isStyleSaved(style)){
            styleDao.save(style);
        }

        sneakerDao.save(sneaker);

        pricingRecordDao.save(pricingRecord);


    }

}
