package com.sapient.oms.serviceHandlers;

import java.util.Date;

import com.sapient.oms.entity.Location;
import com.sapient.oms.entity.Product;
import com.sapient.oms.entity.Store;
import com.sapient.oms.repository.ManageStore;

public class dbRunner {
    public static void main(String[] args) {
        Location location = new Location("Bagmane",530027,"Bangalore","Karnataka","India");
        Store store = new Store(1,"Amazon",12345,"xxx@gmail.com",location,null);
        Product product = new Product(1,"Shampoo",new Date(),new Date(),190.25);
        ManageStore str_mng = new ManageStore();
        System.out.println(str_mng.addProduct(product));
        System.out.println(str_mng.addLocation(location));
        System.out.println(str_mng.addStore(store));
    }
}
