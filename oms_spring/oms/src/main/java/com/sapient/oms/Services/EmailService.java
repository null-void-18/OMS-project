package com.sapient.oms.services;

import java.util.*;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sapient.oms.entity.Customer;

public class EmailService {

    public String sendmail(String recipient, Customer customer) {

        String sender = "kiransekhar18@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kiransekhar18@gmail.com", "zvkblhsboobsibeo");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(sender);

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject("Subject");

            message.setText("This is the text");
           
            Transport.send(message);
            return "Mail sent successfully";
        } catch (MessagingException mex) {
            return "Mail not sent";
        }
    }
}