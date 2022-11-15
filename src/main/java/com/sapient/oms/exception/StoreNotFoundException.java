package com.sapient.oms.exception;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String errMessage) {
        super(errMessage);
    }
}
