package com.sapient.oms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.oms.Mail.Mail;
import com.sapient.oms.entity.Customer;

@ExtendWith(MockitoExtension.class)
public class EmailTest {

    @Test
    void testSendMailSuccess() {
        Mail sendmail = new Mail();
        String actualResult = sendmail.mailUserOnCreation(new Customer(10, "xxx", "*****", "kirankoolkidoz@gmail.com"));
        String expectedResult = "Mail sent successfully";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testSendMailFailure() {
        Mail sendmail = new Mail();
        String actualResult = sendmail.mailUserOnCreation(new Customer());
        String expectedResult = "Mail not sent";
        assertEquals(expectedResult, actualResult);
    }  
}
