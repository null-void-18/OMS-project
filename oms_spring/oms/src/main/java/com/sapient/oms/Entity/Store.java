package com.sapient.oms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "store_id")
    private int id;
    private String shopName;
    private int contactNumber;
    private String emailId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.store")
    private Set<Inventory> inventory = new HashSet<Inventory>();
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    public Set<Inventory> getInventory() {
        return inventory;
    }
    public void setInventory(Set<Inventory> inventory) {
        this.inventory = inventory;
    }

    public Store(int id, String shopName, int contactNumber, String emailId, Location location,Set<Inventory> inventories) {
        this.id = id;
        this.shopName = shopName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.location = location;
        this.inventory = inventories;
    }
    public Store(int id, String shopName, int contactNumber, String emailId) {
        this.id = id;
        this.shopName = shopName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;

    }

    public Store() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    

    @Override
    public int hashCode() {
        return this.id;
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
        if (this.id != store.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[ StoreId:- " + this.id);
        strBuilder.append(", Shop name:-  " + this.shopName);
        strBuilder.append(", Contact:- " + this.contactNumber);
        strBuilder.append(",\n Address:- " + this.location);
        return strBuilder.toString();
    }
}