package com.sapient.oms.controller;

import com.sapient.oms.entity.Customer;
import com.sapient.oms.services.EmailService;

public class ManageMail {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Kiran Sekhar", "password", "kirankoolkidoz@gmail.com");

        EmailService mail = new EmailService();
        String recipient = customer.getEmail();
        mail.sendmail(recipient,customer);
    }
}
