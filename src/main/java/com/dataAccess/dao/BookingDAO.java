package com.dataAccess.dao;

import com.dataAccess.bean.Booking;
import com.dataAccess.dao.common.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by oliver on 27/02/15.
 */
public class BookingDAO implements DAO<Booking>{

    private EntityManagerFactory emf;

    private static final BookingDAO instance = new BookingDAO();
    public static BookingDAO getInstance(){
        return instance;
    }

    private BookingDAO(){
        emf = Persistence.createEntityManagerFactory("WebServicesProjectPU");
    }

    @Override
    public int create(Booking booking) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        int id = 0;

        try{
            t.begin();
            em.persist(booking);
            em.flush();
            id = booking.getBookingNumber();
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
    public Booking read(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        Booking booking = null;
        try{
            t.begin();
            booking = em.find(Booking.class,id);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return booking;
    }

    @Override
    public void update(Booking booking) {

    }

    @Override
    public void delete(Booking booking) {

    }
}
