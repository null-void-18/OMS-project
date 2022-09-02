package com.sapient.oms.Mail;

import com.sapient.oms.entity.Customer;
import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.Store;
import com.sapient.oms.services.EmailService;

public class Mail {

    private EmailService sendEmail = new EmailService();

    public String mailUserOnCreation(Customer customer) {
        String subject = "Welcome to Oms";
        String body = "<h3>Hi " + customer.getCustomerName() + ". Your account has been successfully created into oms.</h3>";
        String response = sendEmail.sendmail(subject, body, customer.getEmail());
        return response;
    }

    public String mailStoreOnCreation(Store store) {
        String subject = "Welcome to Oms";
        String body = "<h3>Hi " + store.getShopName() + ". Your store has been successfully created into oms.</h3>";
        String response = sendEmail.sendmail(subject, body, store.getEmailId());
        return response;
    }

    public void mailonOrderCreation(Order order) {
        String subject = "Order Placed";
        String body = "<h3>Hi " + order.getOrderStatus().toString() + ". Your order has been successfully Placed</h3>"
                + "<h4>Order Details</h4></br>"
                + "<p><b>Order Id:</b>" + order.getId() + "</p>"
                + "<p><b>Order Price:</b>" + order.getPrice() + "</p>"
                + "<p>We are looking forward to deliever the order asap</p>";
        sendEmail.sendmail(subject, body, order.getOrderStatus().toString());

    }

    public void mailonOrderUpdate(Customer customer) {
        String subject = "Order Updated";
        String body = "<h3>Hi " + customer.getCustomerName() + ". Your order has been successfully Updated</h3>"
                + "<p>We are looking forward to deliever the order asap</p>";
        sendEmail.sendmail(subject, body, customer.getEmail());

    }

    public void mailonOrderCancellation(Customer customer) {
        String subject = "Order Cancelled";
        String body = "<h3>Hi " + customer.getCustomerName() + ". Your order has been successfully cancelled</h3>"
                + "<p>Please rate your experience on our site</p>";
        sendEmail.sendmail(subject, body, customer.getEmail());
    }

}
