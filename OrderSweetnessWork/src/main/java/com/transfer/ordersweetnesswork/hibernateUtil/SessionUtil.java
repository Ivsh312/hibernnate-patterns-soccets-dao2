/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class SessionUtil {
        Session  session = null;
    Transaction transaction = null;

    public Transaction getTransaction() {
        return transaction;
    }

    public Session getSession() {
        return session;
    }
    
    public void openSession(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public Transaction openTransaction(){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return transaction;
    }
}
