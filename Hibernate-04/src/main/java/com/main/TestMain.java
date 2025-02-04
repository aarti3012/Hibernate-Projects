package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Employee;
import com.model.Laptop;

public class TestMain {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setEid(101);
        e1.setEname("aarti");
        e1.setMono(78961128830L);

        Laptop l1 = new Laptop();
        l1.setLid(1111);
        l1.setLname("hp");
        l1.setPrice(85000);

        e1.setLap(l1);
        l1.setEmp(e1);

        session.save(e1);
        session.save(l1);
        txn.commit();
        System.out.println("record saved....!");

        session.close();
        factory.close();
    }
}