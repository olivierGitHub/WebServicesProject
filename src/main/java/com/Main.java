package com;

import com.dataAccess.bean.Booking;
import com.dataAccess.bean.Customer;
import com.dataAccess.bean.Room;
import com.dataAccess.dao.BookingDAO;
import com.dataAccess.dao.CustomerDAO;
import com.dataAccess.dao.RoomDAO;

import java.util.Date;

/**
 * Created by oliver on 27/02/15.
 */
public class Main {

    public static void main (String [] args){
        Room room = new Room();
            room.setRoomNumber(3535);
            room.setRoomType("Single");
            room.setRoomDimension(25);
        RoomDAO.getInstance().create(room);

        Customer customer = new Customer();
            customer.setFirstName("Terry");
            customer.setLastName("Bogard");
        CustomerDAO.getInstance().create(customer);

        Booking booking = new Booking();
            booking.setArrivalDate(new Date());
            booking.setDepartureDate(new Date());
        BookingDAO.getInstance().create(booking);

        System.out.println(RoomDAO.getInstance().read(3).getRoomNumber());
        System.out.println(CustomerDAO.getInstance().read(3).getFirstName());
        System.out.println(BookingDAO.getInstance().read(3).getArrivalDate());


        System.exit(1);
    }
}
