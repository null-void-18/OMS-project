package com.sapient.oms.entity;

import java.time.LocalTime;
import java.util.List;

public class Store {
    private int id;
    private String name;
    private String address;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<Product> products;
    private List<String> openingDays;
    
    
}
