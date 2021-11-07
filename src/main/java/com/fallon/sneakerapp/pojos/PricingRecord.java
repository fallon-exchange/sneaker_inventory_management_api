package com.fallon.sneakerapp.pojos;

import java.time.LocalDate;

public class PricingRecord {

    private int pricingRecordId;
    private int sneakerId;
    private LocalDate dateOfRecord;
    private double goatLowestPrice;
    private double goatHighestPrice;
    private double stockXLowestPrice;
    private double flightClubLowestPrice;
    private double stadiumGoodsLowestPrice;
    private double retailPrice;

    public int getPricingRecordId() {
        return pricingRecordId;
    }

    public void setPricingRecordId(int pricingRecordId) {
        this.pricingRecordId = pricingRecordId;
    }

    public int getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(int sneakerId) {
        this.sneakerId = sneakerId;
    }

    public LocalDate getDateOfRecord() {
        return dateOfRecord;
    }

    public void setDateOfRecord(LocalDate dateOfRecord) {
        this.dateOfRecord = dateOfRecord;
    }

    public double getGoatLowestPrice() {
        return goatLowestPrice;
    }

    public void setGoatLowestPrice(double goatLowestPrice) {
        this.goatLowestPrice = goatLowestPrice;
    }

    public double getGoatHighestPrice() {
        return goatHighestPrice;
    }

    public void setGoatHighestPrice(double goatHighestPrice) {
        this.goatHighestPrice = goatHighestPrice;
    }

    public double getStockXLowestPrice() {
        return stockXLowestPrice;
    }

    public void setStockXLowestPrice(double stockXLowestPrice) {
        this.stockXLowestPrice = stockXLowestPrice;
    }

    public double getFlightClubLowestPrice() {
        return flightClubLowestPrice;
    }

    public void setFlightClubLowestPrice(double flightClubLowestPrice) {
        this.flightClubLowestPrice = flightClubLowestPrice;
    }

    public double getStadiumGoodsLowestPrice() {
        return stadiumGoodsLowestPrice;
    }

    public void setStadiumGoodsLowestPrice(double stadiumGoodsLowestPrice) {
        this.stadiumGoodsLowestPrice = stadiumGoodsLowestPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
