package com.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Customer;
import com.model.Product;

public class TestMain3 {
    public static void main(String[] args) {
    	 SessionFactory factory = HibernateUtil.getSessionFactory();
         Session session = factory.openSession();
         Transaction txn = session.beginTransaction();
         
         Product p1=new Product(101,"TV","Black",null);
         Product p2=new Product(102,"Laptop","gray", null);
         Product p3=new Product(103,"Ring","white", null);
         Product p4=new Product(104,"Chair","Blue", null);
         Product p5=new Product(105,"Monitor","black", null);
         
         Set<Product> pset1=new HashSet<Product>();
         pset1.add(p1);
         pset1.add(p2);
         pset1.add(p3);
         pset1.add(p4);
         pset1.add(p5);
         
         Set<Product> pset2=new HashSet<Product>();
         pset2.add(p1);
         pset2.add(p2);
         pset2.add(p3);
         pset2.add(p4);
         pset2.add(p5);
         
         Customer c1=new Customer(1,"Aarti","8421128830",pset1);
         
         Customer c2=new Customer(2,"pravin","8010972766",pset2);
         
         Set<Customer> cset=new HashSet<Customer>();
         cset.add(c1);
         cset.add(c2);
         
         p1.setcSet(cset);
         p2.setcSet(cset);
         p3.setcSet(cset);
         p4.setcSet(cset);
         p5.setcSet(cset);
         
         session.save(c1);
         session.save(c2);
         txn.commit();
         System.out.println("record saved...!");
    }
}
