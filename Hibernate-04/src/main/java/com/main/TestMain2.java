package com.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Department;
import com.model.Employe;

public class TestMain2 {
	public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        
        Employe e1=new Employe(101,"aarti",8421128830l);
        Employe e2=new Employe(102,"mahesh",9876454379l);
        Employe e3=new Employe(103,"pravin",9876454379l);
        Employe e4=new Employe(104,"shravan",9876454379l);
        Employe e5=new Employe(105,"yash",9876454379l);
        
        Set<Employe> set1=new HashSet<Employe>();
        set1.add(e1);
        set1.add(e2);
        set1.add(e3);
        
        Department d1=new Department();
        d1.setDid(1111);
        d1.setDname("IT");
        d1.seteSet(set1);
        
        Set<Employe> set2=new HashSet<Employe>();
        set2.add(e4);
        set2.add(e5);
        
        Department d2=new Department();
        d2.setDid(2222);
        d2.setDname("COMP");
        d2.seteSet(set2);
        
        e1.setDept(d1);
        e2.setDept(d1);
        
        session.save(d1);
        session.save(d2);
        
        txn.commit();
        System.out.println("records saved....!");
        
	}
}
