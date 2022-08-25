package com.sapient.oms.exception;

public class StoreNotFoundException extends Exception {
    private String errMessage;

    public StoreNotFoundException() {
        this.errMessage = "Store Not Found";
    }

    @Override
    public String getMessage() {
        return this.errMessage;
    }
}
