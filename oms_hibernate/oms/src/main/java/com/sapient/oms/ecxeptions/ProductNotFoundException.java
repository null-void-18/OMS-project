package com.sapient.oms.ecxeptions;

public class ProductNotFoundException extends IllegalArgumentException {
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
