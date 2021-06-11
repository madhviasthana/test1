package com.example.Invoice.Model;

import javax.persistence.*;
import java.security.PrivateKey;

@Entity
@Table(name = "CITY_TBL")
public class City {
    @Id
    private int invoiceId;
    @Column(nullable = false,updatable = false)
    private String cityCode;
    @Column(nullable = false,updatable = false)
    private String cityName;

    public City(int invoiceId, String cityCode, String cityName) {
        this.invoiceId = invoiceId;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }
    public City()
    {

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "invoiceId=" + invoiceId +
                ", cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
