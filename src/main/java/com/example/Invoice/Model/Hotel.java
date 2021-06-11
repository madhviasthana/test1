package com.example.Invoice.Model;

import javax.persistence.*;

@Entity
@Table(name = "HOTEL_TBL")
public class Hotel {
    @Id
    private int invoiceId;
    private String cityCode;
    private String hotelName;
    public Hotel()
    {

    }

    public Hotel(int invoiceId, String cityCode, String hotelName) {
        this.invoiceId = invoiceId;
        this.cityCode = cityCode;
        this.hotelName = hotelName;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "invoiceId=" + invoiceId +
                ", cityCode='" + cityCode + '\'' +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
