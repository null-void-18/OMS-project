package com.sapient.oms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.oms.entity.Store;
import com.sapient.oms.notification.EmailTemplate;
import com.sapient.oms.repository.StoreRepository;

@Service
public class AdminService implements IAdminService {

    @Autowired
    StoreRepository storeRepository;
    EmailTemplate emailTemplate = new EmailTemplate();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createStore(Store store) {
        Store savedStore = storeRepository.save(store);
        emailTemplate.mailStoreOnCreation(savedStore);
        return savedStore.getId();
    }

}
