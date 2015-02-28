package com.dataAccess.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by oliver on 27/02/15.
 */
@Entity
public class Customer implements Serializable{

    @Id
    @GeneratedValue
    private int idCustomer;
    private String firstName;
    private String lastName;

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
