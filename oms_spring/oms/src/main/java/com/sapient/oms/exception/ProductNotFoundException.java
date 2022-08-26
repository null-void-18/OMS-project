package com.sapient.oms.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String errMessage) {
        super(errMessage);
    }
}
