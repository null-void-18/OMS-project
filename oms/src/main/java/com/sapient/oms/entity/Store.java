package com.sapient.oms.entity;

import java.util.List;

public class Store {
    
  static int store_id=0;

  private String storeId;
  private String shopName;
  private String owner;
  private Contact contact;
  private Timing timing;
  private Location location;
  private List<Product> products;

//   incrementing the id
private void increment(){
    store_id++;
}

public Store(String storeId, String shopName, String owner, Contact contact, Timing timing, Location location,
        List<Product> products){
    this.storeId = storeId;
    this.shopName = shopName;
    this.owner = owner;
    this.contact = contact;
    this.timing = timing;
    this.location = location;
    this.products = products;
}

// overloaded constructor
public Store(String shopName, String owner, Contact contact, Timing timing, Location location,
List<Product> products){
    // store_id will be provided by system
   this(Integer.toString(Store.store_id),shopName,owner,contact,timing,location,products);
   increment();
}


public String getStoreId() {
    return storeId;
}
public void setStoreId(String storeId) {
    this.storeId = storeId;
}
public String getShopName() {
    return shopName;
}
public void setShopName(String shopName) {
    this.shopName = shopName;
}
public String getOwner() {
    return owner;
}
public void setOwner(String owner) {
    this.owner = owner;
}
public Contact getContact() {
    return contact;
}
public void setContact(Contact contact) {
    this.contact = contact;
}
public Timing getTiming() {
    return timing;
}
public void setTiming(Timing timing) {
    this.timing = timing;
}
public Location getLocation() {
    return location;
}
public void setLocation(Location location) {
    this.location = location;
}
public List<Product> getProducts() {
    return products;
}
public void setProducts(List<Product> products) {
    this.products = products;
}

@Override
public String toString() {
    
    return "[ StoreId:- "+this.storeId+", Shop name:-  "+this.shopName+", Owner:- "+this.owner+", Contact:- "+this.contact+",\n Address:- "+this.location+", Timing:- "+this.timing+"\n Products:- "+this.products.size()+" ]\n";
}

public void listProducts(){
  
    for(Product product: products){
        System.out.println(product);
    }
}

}
