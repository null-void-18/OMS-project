package com.sapient.oms.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @NotNull
    private String customerName;
    private String password;

    @Email
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
        strBuildr.append(", Email Id:- " + this.email + " ]\n");

        return strBuildr.toString();
    }

}