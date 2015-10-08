package com.d2s2.sinethn.nav.Leads;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by Sineth N on 8/17/2015.
 */
public class Lead implements Serializable {
    private String leadName;
    private String leadID;
    private String phoneNumberPrimary;
    private String vehicleType;
    private String address;
    private String VEHICLE_TABLE ;
    private String VEHICLE_ID ;
    private String OFFICER_ID  ;
    private String LEAD_ID_VEHICLE ;
    private String FTYPE_ID ;
    private String model;
    private String capital;
    private String expected;
    private String REG_YEAR;
    private String REG_NO ;
    private String Brand;

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadID() {
        return leadID;
    }

    public void setLeadID(String leadID) {
        this.leadID = leadID;
    }

    public String getPhoneNumberPrimary() {
        return phoneNumberPrimary;
    }


    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setPhoneNumberPrimary(String phoneNumberPrimary) {
        this.phoneNumberPrimary = phoneNumberPrimary;
    }


    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getFTYPE_ID() {
        return FTYPE_ID;
    }

    public void setFTYPE_ID(String FTYPE_ID) {
        this.FTYPE_ID = FTYPE_ID;
    }

    public String getLEAD_ID_VEHICLE() {
        return LEAD_ID_VEHICLE;
    }

    public void setLEAD_ID_VEHICLE(String LEAD_ID_VEHICLE) {
        this.LEAD_ID_VEHICLE = LEAD_ID_VEHICLE;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOFFICER_ID() {
        return OFFICER_ID;
    }

    public void setOFFICER_ID(String OFFICER_ID) {
        this.OFFICER_ID = OFFICER_ID;
    }

    public String getREG_NO() {
        return REG_NO;
    }

    public void setREG_NO(String REG_NO) {
        this.REG_NO = REG_NO;
    }

    public String getREG_YEAR() {
        return REG_YEAR;
    }

    public void setREG_YEAR(String REG_YEAR) {
        this.REG_YEAR = REG_YEAR;
    }

    public String getVEHICLE_ID() {
        return VEHICLE_ID;
    }

    public void setVEHICLE_ID(String VEHICLE_ID) {
        this.VEHICLE_ID = VEHICLE_ID;
    }

    public String getVEHICLE_TABLE() {
        return VEHICLE_TABLE;
    }

    public void setVEHICLE_TABLE(String VEHICLE_TABLE) {
        this.VEHICLE_TABLE = VEHICLE_TABLE;
    }

}
