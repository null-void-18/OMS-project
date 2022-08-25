package com.sapient.oms.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sapient.oms.entity.Store;

@SpringBootApplication
public class StoreTest {
    private Store store;
    private static int id;
    private static String shopName;
    private static int contactNumber;
    private static String emailId;

    @BeforeAll
    static void setup(){
        id = 1;
        shopName = "Amazon";
        contactNumber = 1234;
        emailId = "xxx@gmail.com";
    }

    @BeforeEach
    void initialize(){
        store = new Store();
    }

    @Test
    void testId() {
        store.setId(1);
        assertEquals(id, store.getId());
    }

    @Test
    void testShopName() {
        store.setShopName("Amazon");
        assertEquals(shopName, store.getShopName());
    }

    @Test
    void testContactNumber() {
        store.setContactNumber(1234);
        assertEquals(contactNumber, store.getContactNumber());
    }

    @Test
    void testEmail() {
        store.setEmailId("xxx@gmail.com");;
        assertEquals(emailId, store.getEmailId());
    }

}