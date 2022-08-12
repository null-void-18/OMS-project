package com.sapient.oms.entity;

public class Customer {
    private int customerId;
    private String customerName;
    private String password;
    private String email;
 
    public Customer(int customerId, String customerName, String password, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.password = password;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder strBuildr = new StringBuilder();
        strBuildr.append("Customer Id:- " + this.customerId);
        strBuildr.append(", Customer Name:- " + this.customerName);
        strBuildr.append(", Email Id:- " + this.email+ " ]\n");
 
        return strBuildr.toString();
    }


}
