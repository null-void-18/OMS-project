package com.sapient.oms.entity;

public class Timing {
    
    private String opensAt;
    private String closesAt;
    
    public Timing(String opensAt, String closesAt) {
        this.opensAt = opensAt;
        this.closesAt = closesAt;
    }

    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[ Opens At:- "+this.opensAt+", ClosesAt:-  "+this.closesAt+" ]";
    }
    

}
