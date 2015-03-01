package com.dataAccess.dao.common;

/**
 * Created by oliver on 27/02/15.
 */
public interface DAO<T> {

    int create(T obj);
    T read (int id);
    void update (T obj);
    void delete(int id);
}
