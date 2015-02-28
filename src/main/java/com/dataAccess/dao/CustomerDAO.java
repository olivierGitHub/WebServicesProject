package com.dataAccess.dao;

import com.dataAccess.bean.Customer;
import com.dataAccess.dao.common.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * Created by oliver on 27/02/15.
 */
public class CustomerDAO implements DAO<Customer> {

    private EntityManagerFactory emf;

    private static final CustomerDAO instance = new CustomerDAO();
    public static CustomerDAO getInstance(){
        return instance;
    }

    private CustomerDAO(){
        emf = Persistence.createEntityManagerFactory("WebServicesProjectPU");
    }

    @Override
    public int create(Customer customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        int id = 0;

        try{
            t.begin();
            em.persist(customer);
            em.flush();
            id = customer.getIdCustomer();
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return id;
    }

    @Override
    public Customer read(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        Customer customer = null;
        try{
            t.begin();
            customer = em.find(Customer.class,id);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try{
            t.begin();
            em.merge(customer);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }

    }

    @Override
    public void delete(Customer customer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try{
            t.begin();
            em.remove(customer);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }

    }
}
