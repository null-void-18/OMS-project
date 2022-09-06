package com.sapient.oms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.oms.controller.AdminController;
import com.sapient.oms.entity.Store;
import com.sapient.oms.services.AdminService;

@SpringBootTest
class AdminControllerTest {
    @InjectMocks
    AdminController adminController;
    @Mock
    AdminService adminService;

    @Test
    void testCreateStore() {
        Store store = new Store();
        when(adminService.createStore(store)).thenReturn(2);
        int storeid = adminController.createStore(store);
        assertEquals(2, storeid);

    }

}
