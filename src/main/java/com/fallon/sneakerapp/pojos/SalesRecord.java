package com.fallon.sneakerapp.pojos;

import java.time.LocalDate;

public class SalesRecord {

    private int sneakerId;
    private int invoiceId;
    private LocalDate dateSold;
    private int priceSold;

    public int getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(int sneakerId) {
        this.sneakerId = sneakerId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LocalDate getDateSold() {
        return dateSold;
    }

    public void setDateSold(LocalDate dateSold) {
        this.dateSold = dateSold;
    }

    public int getPriceSold() {
        return priceSold;
    }

    public void setPriceSold(int priceSold) {
        this.priceSold = priceSold;
    }
}
