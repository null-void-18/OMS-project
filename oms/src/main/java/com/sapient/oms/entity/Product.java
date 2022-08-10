package com.sapient.oms.entity;

import java.util.Date;

import com.sapient.oms.enums.Flag;

public class Product {
       
     private String prodId;
     private String title;
     private float price;
     private Date mfg;
     private Date exp;
     private Flag flag;
     private String description;
     private Integer quantity;

     static int product_id=0;

          //   incrementing the id
private void increment(){
    product_id++;
}
     
     public Product(String prodId, String title, float price, Date mfg, Date exp, Flag flag, String description,
            Integer quantity) {
        this.prodId = prodId;
        this.title = title;
        this.price = price;
        this.mfg = mfg;
        this.exp = exp;
        this.flag = flag;
        this.description = description;
        this.quantity = quantity;
    }
 
    public Product(String title, float price, Date mfg, Date exp, Flag flag, String description,
    Integer quantity) {
     this(Integer.toString(Product.product_id),title,price,mfg,exp,flag,description,quantity);
     increment();
}

@Override
public String toString() {
    // TODO Auto-generated method stub
    return "[ Product Id:- "+this.prodId+", Title:- "+this.title+", Price:-  "+this.price+", Manufactured:- "+this.mfg+", Expiry:- "+this.exp+"\n Flag:- "+this.flag+", Desc:- "+this.description+", Quantity:- "+this.quantity+" ]";
}
   
}
