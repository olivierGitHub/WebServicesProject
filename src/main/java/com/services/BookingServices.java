package com.services;

import com.dataAccess.bean.Booking;
import com.dataAccess.dao.BookingDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by oliver on 27/02/15.
 */
@Path("/booking")
public class BookingServices {

    Booking booking = new Booking();
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try{
                booking.setArrivalDate(sdf.parse("15/06/2015"));
                booking.setDepartureDate(sdf.parse("22/06/2015"));
            }catch(ParseException e){
                e.printStackTrace();
            }
        }

    @GET
    @Path("/create")
    @Produces("text/html")
    public String createBooking(){
        return "<h2>Votre identifiant de réservation est le: "
                + BookingDAO.getInstance().create(booking) + "</h2>"
                + "</br>"
                + "<h3> Nous sommes heureux de vous acceuillir dans notre hotel"
                + " du   " + booking.getArrivalDate() + "   au   " + booking.getDepartureDate()
                + ".</h3>";
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Booking readBooking(){
        return BookingDAO.getInstance().read(1);
    }

    @GET
    @Path("/update")
    @Produces("text/html")
    public String updateBooking(){
        booking.setArrivalDate(new Date());
        booking.setDepartureDate(new Date());
        BookingDAO.getInstance().update(booking);
        return "<h3> Update Completed</h3>";
    }

    @GET
    @Path("/delete")
    @Produces("text/html")
    public String deleteBooking(){
        BookingDAO.getInstance().delete(booking);
        return "<h3> Delete Completed</h3>";
    }

    @GET
    @Path("/readALL")
    @Produces("application/json")
    public List<Booking> readAllBooking(){
        return BookingDAO.getInstance().readALL();
    }

}
