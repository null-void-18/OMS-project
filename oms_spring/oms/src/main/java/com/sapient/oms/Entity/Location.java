package com.sapient.oms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "location")
public class Location {
    @Id
    private int id;
    @NotBlank(message = "please provide address here")
    private String lineAddress;
    private int pincode;
    private String city;
    private String state;
    private String country;

    public Location(int id, String lineAddress, int pincode, String city, String state, String country) {
        this.lineAddress = lineAddress;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.id = id;
    }

    public Location() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLineAddress() {
        return lineAddress;
    }

    public void setLineAddress(String lineAddress) {
        this.lineAddress = lineAddress;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location location = (Location) obj;
        if (this.id != location.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder strBuildr = new StringBuilder();
        strBuildr.append(", Address:- " + this.lineAddress);
        strBuildr.append(", Pincode:- " + this.pincode);
        strBuildr.append(", City:- " + this.city);
        strBuildr.append(", State:- " + this.state);
        strBuildr.append(", Country:- " + this.country + " ]\n");
        return strBuildr.toString();
    }

}
