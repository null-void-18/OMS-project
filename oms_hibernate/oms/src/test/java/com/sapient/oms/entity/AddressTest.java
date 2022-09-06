package com.sapient.oms.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddressTest {

    @Mock
    Address address;

    static Address checkAddress=new Address();

    @BeforeAll
    static void setup(){
        checkAddress.setId(1);
        checkAddress.setLine1("%7 Kapil Vihar Colony");
        checkAddress.setLine2("Near Banna Devi GT Road");
        checkAddress.setPincode("202001");
        checkAddress.setCity("Aligarh");
        checkAddress.setState("Up");
        checkAddress.setCountry("India");
    }


    @Test
    void testGetId() {
        when(address.getId()).thenReturn(checkAddress.getId());
        assertEquals(checkAddress.getId(), address.getId());
        verify(address, times(1)).getId();
    }

    @Test
    void testGetLine1() {
        when(address.getLine1()).thenReturn(checkAddress.getLine1());
        assertEquals(checkAddress.getLine1(), address.getLine1());
        verify(address, times(1)).getLine1();
    }
    @Test
    void testGetLine2() {
        when(address.getLine2()).thenReturn(checkAddress.getLine2());
        assertEquals(checkAddress.getLine2(), address.getLine2());
        verify(address, times(1)).getLine2();
    }
    @Test
    void testGetPincode() {
        when(address.getPincode()).thenReturn(checkAddress.getPincode());
        assertEquals(checkAddress.getPincode(), address.getPincode());
        verify(address, times(1)).getPincode();
    }
    @Test
    void testGetCity() {
        when(address.getCity()).thenReturn(checkAddress.getCity());
        assertEquals(checkAddress.getCity(), address.getCity());
        verify(address, times(1)).getCity();
    }
    @Test
    void testGetState() {
        when(address.getState()).thenReturn(checkAddress.getState());
        assertEquals(checkAddress.getState(), address.getState());
        verify(address, times(1)).getState();
    }
    @Test
    void testGetCountry() {
        when(address.getCountry()).thenReturn(checkAddress.getCountry());
        assertEquals(checkAddress.getCountry(), address.getCountry());
        verify(address, times(1)).getCountry();
    }
    
}