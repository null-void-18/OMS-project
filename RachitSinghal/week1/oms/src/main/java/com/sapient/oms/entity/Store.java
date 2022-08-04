package com.sapient.oms.entity;

import java.time.LocalTime;
import java.util.List;

public class Store {
    private int id;
    private String name;
    private String email;
    private String number;
    private String address;
    private List<String> openingDays;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<Product> products;
}
