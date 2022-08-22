package com.sapient.oms.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocationTest {
    private Location location;
    private static String lineAddress;
    private static int pincode;
    private static String city;
    private static String state;
    private static String country;

    @BeforeAll
    static void setup(){
        lineAddress = "Bagmane";
        pincode = 530027;
        city = "Bangalore";
        state = "Karnataka";
        country = "India";
    }

    @BeforeEach
    void initialize() {
        location = new Location();    
    }

    @Test
    void testLineAddress(){
        location.setLineAddress("Bagmane");
        assertEquals(lineAddress, location.getLineAddress());
    }


    @Test
    void testPincode(){
        location.setPincode(530027);
        assertEquals(pincode, location.getPincode());
    }

    @Test
    void testCity(){
        location.setCity("Bangalore");
        assertEquals(city, location.getCity());
    }

    @Test
    void testState(){
        location.setState("Karnataka");
        assertEquals(state, location.getState());
    }

    @Test
    void testCountry(){
        location.setCountry("India");
        assertEquals(country, location.getCountry());
    }
}