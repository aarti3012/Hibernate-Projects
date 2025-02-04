package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.DyChinchwad;
import com.model.DyPatil;
import com.model.DyPune;

public class TestMain {
public static void main(String[] args) {
	SessionFactory factory=HibernateUtil.getSessionFactory();
	Session session=factory.openSession();
	Transaction txn=session.beginTransaction();
	
	DyPune pune=new DyPune();
	pune.setSid(101);
	pune.setSname("aarti");
	pune.setMono(7865432123l);
	pune.setHostelFcility(true);
	
	DyChinchwad ch=new DyChinchwad();
	ch.setSid(102);
	ch.setSname("isha");
	ch.setMono(987675432l);
	ch.setBusFacility(false);
	
	DyPatil dy=new DyPatil();
	dy.setSid(1);
	dy.setSname("raj");
	dy.setMono(8976543122l);
	
	
	session.save(pune);
	session.save(ch);
	txn.commit();
	
}
}
