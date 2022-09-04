package com.sapient.oms.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;
    private String shopName;
    private int contactNumber;
    private String emailId;
    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private Collection<Inventory> inventory = new ArrayList<Inventory>();

    public Collection<Inventory> getInventory() {
        return inventory;
    }
    public void setInventory(Collection<Inventory> inventories) {
        this.inventory = inventories;
    }

    public Store(int storeId, String shopName, int contactNumber, String emailId,Collection<Inventory> inventories) {
        this.storeId = storeId;
        this.shopName = shopName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.inventory = inventories;
    }
    public Store(Store store) {
        this.storeId = store.storeId;
        this.shopName = store.shopName;
        this.contactNumber = store.contactNumber;
        this.emailId = store.emailId;

    }

    public Store() {
    }

    public int getId() {
        return storeId;
    }

    public void setId(int storeId) {
        this.storeId = storeId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public int hashCode() {
        return this.storeId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Store store = (Store) obj;
        if (this.storeId != store.storeId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ StoreId:- " + this.storeId);
        strBuilder.append(", Shop name:-  " + this.shopName);
        strBuilder.append(", Contact:- " + this.contactNumber);
        strBuilder.append(", Products:- "+ this.inventory);
        return strBuilder.toString();
    }
}