package com.sapient.oms.exception;

public class OrderNotFoundException extends Exception {
    private String errMessage;

    public OrderNotFoundException() {
        this.errMessage = "Order Not Found";
    }

    @Override
    public String getMessage() {
        return this.errMessage;
    }
}
