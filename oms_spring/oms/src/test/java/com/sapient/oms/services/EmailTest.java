package com.sapient.oms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.entity.Customer;

@ExtendWith(MockitoExtension.class)
public class EmailTest {

    @Test
    void testSendMailSuccess() {
        EmailService mail = new EmailService();
        String expectedMessage = "Mail sent successfully";
        String actualMessage = mail.sendmail("kirankoolkidoz@gmail.com", new Customer());
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSendMailFailure() {
        EmailService mail = new EmailService();
        String expectedMessage = "Mail not sent";
        String actualMessage = mail.sendmail("", new Customer());
        assertEquals(expectedMessage, actualMessage);
    }
    
}
