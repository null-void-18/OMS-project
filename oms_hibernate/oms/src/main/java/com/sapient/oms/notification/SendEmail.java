package com.sapient.oms.notification;

// Java program to send email

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import javax.mail.Session;
import javax.mail.Transport;

public class SendEmail {
    String sender = "rrchamp456@gmail.com";

    String host = "smtp.gmail.com";

    Properties properties = System.getProperties();

    public String sendMail(String subject, String body, String recipient) {
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        System.out.println(EmailCredentials.password);
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("rrchamp456", EmailCredentials.password);

            }

        });

        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(sender));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            message.setSubject(subject);

            message.setContent(body, "text/html");

            Transport.send(message);
            return "Mail successfully sent";
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return "Error in sending mail";
        }
    }

}
