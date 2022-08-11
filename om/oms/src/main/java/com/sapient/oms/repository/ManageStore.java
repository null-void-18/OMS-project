package com.sapient.oms.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sapient.oms.entity.Location;
import com.sapient.oms.entity.Product;
import com.sapient.oms.entity.Store;

public class ManageStore {
    private static SessionFactory factory;

    public ManageStore(){
        try{
            factory = new Configuration().configure().buildSessionFactory();

        }catch(Exception ex){
            System.out.println("Error 403 - Cannot connect to MySQL");
        }
    }

    public int addStore(Store store){
       
        Session session = factory.openSession();
        Transaction tx = null;
        Integer storeID = null;

        try{          
            tx = session.beginTransaction();
            storeID = (Integer) session.save(store);
            tx.commit();
        }catch(HibernateException hibr_ex){
            if(tx!=null)
             tx.rollback();
            System.out.println("Error 401 - Cannot insert into DB");
        }finally{
            session.close();
        }
        return storeID;    
    }

    public int addProduct(Product product){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer productID = null;

        try{          
            tx = session.beginTransaction();
            productID = (Integer) session.save(product);
            tx.commit();
        }catch(HibernateException hibr_ex){
            if(tx!=null)
             tx.rollback();
            System.out.println("Error occured while inserting product into the database");
        }finally{
            session.close();
        }

        return productID;
    }

    public int addLocation(Location location){

        Session session = factory.openSession();
        Transaction tx = null;
        Integer locationID = null;

        try{

            tx = session.beginTransaction();
            locationID = (Integer) session.save(location);
            tx.commit();

        }catch(HibernateException hbr_ex){

            if(tx!=null)
             tx.rollback();
            System.out.println("Error Occured while insertingt he timing into the database");
        }finally{
            session.close();
        }

        return locationID;
    }

    
}
