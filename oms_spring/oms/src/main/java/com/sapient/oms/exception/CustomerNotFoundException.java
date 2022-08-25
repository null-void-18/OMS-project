package com.sapient.oms.exception;

public class CustomerNotFoundException extends Exception{
    private String errMessage;

    public CustomerNotFoundException() {
        this.errMessage = "Customer Not Found";
    }

    @Override
    public String getMessage() {
        return this.errMessage;
    }
}
