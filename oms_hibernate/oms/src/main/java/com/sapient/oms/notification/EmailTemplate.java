package com.sapient.oms.notification;

import com.sapient.oms.entity.Order;
import com.sapient.oms.entity.Store;
import com.sapient.oms.entity.User;

public class EmailTemplate {

    private SendEmail sendEmail = new SendEmail();

    public String mailUserOnCreation(User user) {
        String subject = "Welcome to Oms";
        String body = "<h3>Hi " + user.getFirstName() + ". Your account has been successfully created into oms.</h3>";
        String response = sendEmail.sendMail(subject, body, user.getEmail());
        return response;

    }

    public String mailStoreOnCreation(Store store) {
        String subject = "Welcome to Oms";
        String body = "<h3>Hi " + store.getName() + ". Your store has been successfully created into oms.</h3>";
        String response = sendEmail.sendMail(subject, body, store.getEmail());
        return response;

    }

    public void mailonOrderCreation(Order order) {
        String subject = "Order Placed";
        String body = "<h3>Hi " + order.getUser().getFirstName() + ". Your order has been successfully Placed</h3>"
                    +"<h4>Order Details</h4></br>"
                    +"<p><b>Order Id:</b>"+order.getId()+"</p>"
                    +"<p><b>Order Price:</b>"+order.getTotalPrice()+"</p>"
                + "<p>We are looking forward to deliever the order asap</p>";
        sendEmail.sendMail(subject, body, order.getUser().getEmail());

    }

    public void mailonOrderUpdate(User user) {
        String subject = "Order Updated";
        String body = "<h3>Hi " + user.getFirstName() + ". Your order has been successfully Updated</h3>"
                + "<p>We are looking forward to deliever the order asap</p>";
        sendEmail.sendMail(subject, body, user.getEmail());

    }

    public void mailonOrderCancellation(User user) {
        String subject = "Order Cancelled";
        String body = "<h3>Hi " + user.getFirstName() + ". Your order has been successfully cancelled</h3>"
                + "<p>Please rate your experience on our site</p>";
        sendEmail.sendMail(subject, body, user.getEmail());

    }

}
