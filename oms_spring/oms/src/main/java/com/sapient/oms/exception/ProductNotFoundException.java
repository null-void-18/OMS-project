package com.sapient.oms.exception;

public class ProductNotFoundException extends Exception {
    private String errMessage;

    public ProductNotFoundException() {
        this.errMessage = "Product Not Found";
    }

    @Override
    public String getMessage() {
        return this.errMessage;
    }
}
