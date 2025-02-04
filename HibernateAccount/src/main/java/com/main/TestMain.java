package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Account;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            while (true) {
                System.out.println("\n1. Create Account");
                System.out.println("2. View Account Details by Account Number");
                System.out.println("3. Update Account Details");
                System.out.println("4. Deposit Money");
                System.out.println("5. Withdraw Money");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        Transaction tx1 = session.beginTransaction();
                        Account account = new Account();
                        System.out.print("Enter Account Number: ");
                        account.setAcNo(sc.nextLong());
                        sc.nextLine();
                        System.out.print("Enter Account Name: ");
                        account.setAcNme(sc.nextLine());
                        System.out.print("Enter Address: ");
                        account.setAddress(sc.nextLine());
                        System.out.print("Enter Mobile Number: ");
                        account.setMobileNo(sc.nextLong());
                        System.out.print("Enter Aadhar Number: ");
                        account.setAadharNo(sc.nextLong());
                        sc.nextLine();
                        System.out.print("Enter PAN Number: ");
                        account.setPanNo(sc.nextLine());
                        System.out.print("Enter Balance: ");
                        account.setBalance(sc.nextDouble());
                        sc.nextLine();
                        System.out.print("Enter Account Type: ");
                        account.setAcType(sc.nextLine());
                        System.out.print("Enter Gender: ");
                        account.setGender(sc.nextLine());

                        session.save(account);
                        tx1.commit();
                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Account Number: ");
                        long acNo = sc.nextLong();
                        Account fetchedAccount = session.get(Account.class, acNo);
                        if (fetchedAccount != null) {
                            System.out.println("Account Number: " + fetchedAccount.getAcNo());
                            System.out.println("Account Name: " + fetchedAccount.getAcNme());
                            System.out.println("Address: " + fetchedAccount.getAddress());
                            System.out.println("Mobile Number: " + fetchedAccount.getMobileNo());
                            System.out.println("Aadhar Number: " + fetchedAccount.getAadharNo());
                            System.out.println("PAN Number: " + fetchedAccount.getPanNo());
                            System.out.println("Balance: " + fetchedAccount.getBalance());
                            System.out.println("Account Type: " + fetchedAccount.getAcType());
                            System.out.println("Gender: " + fetchedAccount.getGender());
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Account Number: ");
                        long updateAcNo = sc.nextLong();
                        Account updateAccount = session.get(Account.class, updateAcNo);
                        if (updateAccount != null) {
                            System.out.println("1. Update Account Name");
                            System.out.println("2. Update Address");
                            System.out.println("3. Update Mobile Number");
                            System.out.print("Enter your choice: ");
                            int updateChoice = sc.nextInt();
                            sc.nextLine();
                            Transaction tx2 = session.beginTransaction();
                            switch (updateChoice) {
                                case 1:
                                    System.out.print("Enter New Account Name: ");
                                    updateAccount.setAcNme(sc.nextLine());
                                    break;
                                case 2:
                                    System.out.print("Enter New Address: ");
                                    updateAccount.setAddress(sc.nextLine());
                                    break;
                                case 3:
                                    System.out.print("Enter New Mobile Number: ");
                                    updateAccount.setMobileNo(sc.nextLong());
                                    break;
                            }
                            session.update(updateAccount);
                            tx2.commit();
                            System.out.println("Account updated successfully!");
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Account Number: ");
                        long depositAcNo = sc.nextLong();
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = sc.nextDouble();
                        Transaction tx3 = session.beginTransaction();
                        Account depositAccount = session.get(Account.class, depositAcNo);
                        if (depositAccount != null) {
                            depositAccount.setBalance(depositAccount.getBalance() + depositAmount);
                            session.update(depositAccount);
                            tx3.commit();
                            System.out.println("Amount deposited successfully!");
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Account Number: ");
                        long withdrawAcNo = sc.nextLong();
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        Transaction tx4 = session.beginTransaction();
                        Account withdrawAccount = session.get(Account.class, withdrawAcNo);
                        if (withdrawAccount != null) {
                            if (withdrawAccount.getBalance() >= withdrawAmount) {
                                withdrawAccount.setBalance(withdrawAccount.getBalance() - withdrawAmount);
                                session.update(withdrawAccount);
                                tx4.commit();
                                System.out.println("Amount withdrawn successfully!");
                            } else {
                                System.out.println("Insufficient balance!");
                            }
                        } else {
                            System.out.println("Account not found!");
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        sessionFactory.close();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }
}