package com.fallon.sneakerapp.pojos;

import java.time.LocalDate;

public class Sneaker {
    int sneakerId;
    String styleId;
    double size;
    int userId;
    boolean isSold;
    LocalDate dateBought;
    double priceBought;

    public Sneaker(String styleId, double size, int userId, boolean isSold, LocalDate dateBought, double priceBought) {

        this.styleId = styleId;
        this.size = size;
        this.userId = userId;
        this.isSold = isSold;
        this.dateBought = dateBought;
        this.priceBought = priceBought;
    }

    public int getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(int sneakerId) {
        this.sneakerId = sneakerId;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public LocalDate getDateBought() {
        return dateBought;
    }

    public void setDateBought(LocalDate dateBought) {
        this.dateBought = dateBought;
    }

    public double getPriceBought() {
        return priceBought;
    }

    public void setPriceBought(double priceBought) {
        this.priceBought = priceBought;
    }

    @Override
    public String toString() {
        return "Sneaker{" +
                "sneakerId=" + sneakerId +
                ", styleId='" + styleId + '\'' +
                ", size=" + size +
                ", userId=" + userId +
                ", isSold=" + isSold +
                ", dateBought=" + dateBought +
                ", priceBought=" + priceBought +
                '}';
    }
}
