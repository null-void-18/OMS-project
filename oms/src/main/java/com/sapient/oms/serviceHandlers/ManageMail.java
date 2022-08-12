package com.sapient.oms.serviceHandlers;

import com.sapient.oms.entity.Customer;

public class ManageMail {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Kiran Sekhar", "password", "kirankoolkidoz@gmail.com");

        SendMail mail = new SendMail();
        String recipient = customer.getEmail();
        mail.sendmail(recipient,customer);
    }
}
