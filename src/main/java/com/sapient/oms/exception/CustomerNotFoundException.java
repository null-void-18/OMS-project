package com.sapient.oms.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String errMessage) {
        super(errMessage);
    }
}
