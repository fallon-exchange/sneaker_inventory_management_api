package com.fallon.sneakerapp.pojos;

public class Listing {
    int listingId;
    int sneakerId;
    String listingService;
    double listingPrice;

    public Listing() {
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public int getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(int sneakerId) {
        this.sneakerId = sneakerId;
    }

    public String getListingService() {
        return listingService;
    }

    public void setListingService(String listingService) {
        this.listingService = listingService;
    }

    public double getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(double listingPrice) {
        this.listingPrice = listingPrice;
    }
}
