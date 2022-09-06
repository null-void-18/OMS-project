package com.sapient.oms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapient.oms.entity.Store;
import com.sapient.oms.notification.EmailTemplate;
import com.sapient.oms.repository.StoreRepository;
import com.sapient.oms.services.AdminService;

@SpringBootTest
class AdminServiceTest {
    @InjectMocks
    AdminService adminService;
    @Mock
    StoreRepository storeRepository;
    @Mock
    EmailTemplate emailTemplate;

    @Test
    void testCreateStoreService() {
        Store store = new Store();
        store.setId(1);
        store.setName("Jaya");
        when(storeRepository.save(any(Store.class))).thenReturn(store);
        when(emailTemplate.mailStoreOnCreation(store)).thenReturn("Mail successfully sent");
        int storeid = adminService.createStore(store);
        assertEquals(1, storeid);

    }

}
