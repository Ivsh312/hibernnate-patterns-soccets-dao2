/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.transfer.ordersweetnesswork.Service;


import com.transfer.ordersweetnesswork.DAO.IToffeeDAO;
import com.transfer.ordersweetnesswork.entity.Toffee;
import com.transfer.ordersweetnesswork.hibernateUtil.SessionUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class ToffeeDAO implements IToffeeDAO {

    private SessionUtil sessionUtil = new SessionUtil();

    @Override
    public boolean addToffee(Toffee toffee) throws SQLException {
        Session session = null;
        boolean flag = false;
        Transaction transaction = null;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();

            session.save(toffee);

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
    public Toffee getById(Integer id) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        Toffee toffee = null;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();
            
            String sqlQuery = "FROM Toffee WHERE IdToffee = :id";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("id", id);
            toffee = (Toffee) query.uniqueResult();
            System.out.println(toffee.getIdToffee());
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return toffee;
    }

    @Override
    public List<Toffee> getByTestyDesiredAmount(String taste, int numbers) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        List<Toffee> toffee = null;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();
            
            String sqlQuery = "FROM Toffee WHERE taste = :taste";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("taste", taste);
            query.setMaxResults(numbers);
            toffee = (List<Toffee>) query.list();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return toffee;
    }

    @Override
    public int deleteById(int id) throws SQLException {
        Session session = null;
        Transaction transaction = null;
        int result = 0;
        try {
            transaction = sessionUtil.openTransaction();
            session = sessionUtil.getSession();
            
            String sqlDeleteString = "delete Toffee where IdToffee = :id";
            Query query = session.createQuery(sqlDeleteString);
            query.setParameter("id", id);
            result = query.executeUpdate();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

}