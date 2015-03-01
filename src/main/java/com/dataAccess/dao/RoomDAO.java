package com.dataAccess.dao;

import com.dataAccess.bean.Room;
import com.dataAccess.dao.common.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * Created by oliver on 27/02/15.
 */
public class RoomDAO implements DAO<Room> {

    private EntityManagerFactory emf;

    private static final RoomDAO instance = new RoomDAO();
    public static RoomDAO getInstance(){
        return instance;
    }

    private RoomDAO(){
        emf = Persistence.createEntityManagerFactory("WebServicesProjectPU");
    }

    @Override
    public int create(Room room) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        int id = 0;

        try{
            t.begin();
            em.persist(room);
            em.flush();
            id = room.getIdRoom();
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
    public Room read(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        Room room = null;
        try{
            t.begin();
            room = em.find(Room.class,id);
            t.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (t.isActive()){
                t.rollback();
                em.close();
            }
        }
        return room;
    }

    @Override
    public void update(Room room) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try{
            t.begin();
            em.merge(room);
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
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        try{
            t.begin();
            Room room = em.find(Room.class, id);
            em.remove(room);
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
