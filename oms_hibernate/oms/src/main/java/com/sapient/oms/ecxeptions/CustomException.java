package com.sapient.oms.ecxeptions;

public class CustomException extends IllegalArgumentException {
    public CustomException(String msg){
        super(msg);
    }
}
