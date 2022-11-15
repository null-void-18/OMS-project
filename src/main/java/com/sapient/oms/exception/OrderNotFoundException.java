package com.sapient.oms.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String errMessage) {
        super(errMessage);
    }
}
