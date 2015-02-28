package com.services;

import com.dataAccess.bean.Booking;
import com.dataAccess.dao.BookingDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Date;

/**
 * Created by oliver on 27/02/15.
 */
@Path("/booking")
public class BookingServices {

    Booking booking = new Booking();
        {
            booking.setArrivalDate(new Date());
            booking.setDepartureDate(new Date());
        }


    @GET
    @Produces("text/html")
    public String createBooking(){
        return "<h2>Votre identifiant de réservation est le: "
                + BookingDAO.getInstance().create(booking) + "</h2>"
                + "</br>"
                + "<h3> Nous sommes heureux de vous acceuillir dans notre hotel"
                + " du   " + booking.getArrivalDate() + "   au   " + booking.getDepartureDate()
                + ".</h3>";
    }
}
