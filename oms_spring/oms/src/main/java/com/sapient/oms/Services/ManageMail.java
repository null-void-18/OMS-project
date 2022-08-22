package com.sapient.oms.Services;

import com.sapient.oms.Entity.Customer;

public class ManageMail {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Arunraj", "password", "arunrajmathanabalu@gmail.com");

        Email mail = new Email();
        String recipient = customer.getEmail();
        mail.sendmail(recipient,customer);
    }
}