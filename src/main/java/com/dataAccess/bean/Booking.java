package com.dataAccess.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by oliver on 27/02/15.
 */
@Entity
public class Booking {

    @Id
    @GeneratedValue
    private int bookingNumber;
    private Date arrivalDate;
    private Date departureDate;

    public int getBookingNumber() {
        return bookingNumber;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

}
