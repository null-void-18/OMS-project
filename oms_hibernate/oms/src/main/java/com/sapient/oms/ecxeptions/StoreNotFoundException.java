package com.sapient.oms.ecxeptions;

public class StoreNotFoundException extends IllegalArgumentException {
    public StoreNotFoundException(String msg){
        super(msg);
    }
    
}
