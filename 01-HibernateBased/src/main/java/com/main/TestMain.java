package com.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Employee;

public class TestMain {

	public static void main(String[] args) {
		
         SessionFactory factory = HibernateUtil.getSessionFactory();
         Session session = factory.openSession();
         Scanner s = new Scanner(System.in);

         while(true) {
             System.out.println("Enter your choice:");
             System.out.println("1.Insert \n2.Get \n3.Delete \n4.Update \n5.Exit");
             
             int choice = s.nextInt();
             
             switch(choice) {
                 case 1:
                     insertRecord(session, s);
                     break;
                 case 2:
                     getRecord(session, s);
                     break;
                 case 3:
                     deleteEmployee(session, s);
                     break;
                 case 4:
                     updateRecord(session, s);
                     break;
                 case 5:
                     System.out.println("Exiting the application...");
                     session.close();
                     s.close();
                     return;  // Exit the program
                 default:
                     System.out.println("Enter a valid choice");
                     break;
             }
         }
	}

    private static void updateRecord(Session session, Scanner s) {
        Transaction txn = session.beginTransaction();
        System.out.println("Enter eid to update record:");
        Employee emp = session.get(Employee.class, s.nextInt());
        System.out.println("Enter a new name:");
        emp.setEname(s.next());
        System.out.println("Enter a new salary:");
        emp.setSalary(s.nextDouble());
        System.out.println("Enter a new mobile number:");
        emp.setMono(s.nextLong());
        session.update(emp);
        txn.commit();
        System.out.println("Employee updated!");
    }

    private static void deleteEmployee(Session session, Scanner s) {
        Transaction txn = session.beginTransaction();
        System.out.println("Enter eid to delete record:");
        Employee emp = session.get(Employee.class, s.nextInt());
        session.delete(emp);
        txn.commit();
        System.out.println("Record deleted!");
    }

    private static void getRecord(Session session, Scanner s) {
        System.out.println("Enter eid to get record:");
        Employee emp = session.get(Employee.class, s.nextInt());
        System.out.println(emp);
    }

    private static void insertRecord(Session session, Scanner s) {
        Transaction txn = session.beginTransaction();
        Employee emp = new Employee();
        System.out.println("Enter Eid, Ename, Salary, Mono:");
        emp.setEid(s.nextInt());
        emp.setEname(s.next());
        emp.setSalary(s.nextDouble());
        emp.setMono(s.nextLong());
        session.save(emp);
        txn.commit();
        System.out.println("Employee added!");
    }
}