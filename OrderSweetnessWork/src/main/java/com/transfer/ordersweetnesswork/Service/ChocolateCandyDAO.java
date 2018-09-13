/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.Service;


import com.transfer.ordersweetnesswork.DAO.IChocolateCandyDAO;
import com.transfer.ordersweetnesswork.entity.ChocolateCandy;
import com.transfer.ordersweetnesswork.hibernateUtil.SessionUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class ChocolateCandyDAO implements IChocolateCandyDAO {

    private SessionUtil sessionUtil = new SessionUtil();

    @Override
    public boolean addChocolateCandy(ChocolateCandy chocolateCandy) throws SQLException {
        Session session = null;
        boolean flag = false;
        Transaction transaction = null;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();

            session.save(chocolateCandy);

            transaction.commit();
            flag = true;

        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return flag;
    }

    @Override
    public ChocolateCandy getById(Integer id) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        ChocolateCandy chocolateCandy = null;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();
            
            String sqlQuery = "FROM ChocolateCandy WHERE IdChocolateCandy = :id";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("id", id);
            chocolateCandy = (ChocolateCandy) query.uniqueResult();
            System.out.println(chocolateCandy.getIdChocolateCandy());
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return chocolateCandy;
    }

    public List<ChocolateCandy> getByTestyDesiredAmount(String taste, int numbers) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        List<ChocolateCandy> chocolateCandy = null;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();
            
            String sqlQuery = "FROM ChocolateCandy WHERE taste = :taste";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("taste", taste);
            query.setMaxResults(numbers);
            chocolateCandy = (List<ChocolateCandy>) query.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return chocolateCandy;
    }

    @Override
    public int deleteById(int id) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        int result = 0;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();
            
            String sqlDeleteString = "delete ChocolateCandy where IdChocolateCandy = :id";          
            Query query = session.createQuery(sqlDeleteString);
            query.setParameter("id", id);
            result = query.executeUpdate();
 
        }finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }
}
