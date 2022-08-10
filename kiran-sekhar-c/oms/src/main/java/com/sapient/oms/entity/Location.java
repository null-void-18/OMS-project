package com.sapient.oms.entity;

public class Location {
    
    private String streetNumber;
    private String lineAddress;
    private String landmark;
    private String pincode;
    private String city;
    private String state;
    
    public Location(String streetNumber, String lineAddress, String landmark, String pincode, String city,
            String state) {
        this.streetNumber = streetNumber;
        this.lineAddress = lineAddress;
        this.landmark = landmark;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[Street Number "+this.streetNumber+", Address:- "+this.lineAddress+" Landmark:- "+this.landmark+", Pincode:- "+this.pincode+", City:- "+this.city+", State:- "+this.state+" ]\n";
    }

}
