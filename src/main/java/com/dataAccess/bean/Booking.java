package com.dataAccess.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by oliver on 27/02/15.
 */
@Entity
@XmlRootElement
public class Booking {

    @Id
    @GeneratedValue
    private int bookingNumber;
    private String bookingName;
    private int bookingRoom;
    private Date arrivalDate;
    private Date departureDate;

    public int getBookingNumber() {
        return bookingNumber;
    }

    public String getBookingName() {
        return bookingName;
    }
    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public int getBookingRoom() {
        return bookingRoom;
    }
    public void setBookingRoom(int bookingRoom) {
        this.bookingRoom = bookingRoom;
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
