package com.services;

import com.dataAccess.bean.Booking;
import com.dataAccess.dao.BookingDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by oliver on 27/02/15.
 */
@Path("/booking")
public class BookingServices {

    @GET
    @Path("/create")
    @Produces("text/html")
    public String createBooking(@QueryParam("bookingName") String bookingName,
                                @QueryParam("bookingRoom") int bookingRoom,
                                @QueryParam("arrivalDate") String arrivalDate,
                                @QueryParam("departureDate") String departureDate){
        Booking booking1 = new Booking();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            booking1.setBookingName(bookingName);
            booking1.setBookingRoom(bookingRoom);
            booking1.setArrivalDate(sdf.parse(arrivalDate));
            booking1.setDepartureDate(sdf.parse(departureDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        return "<h2>Votre identifiant de réservation est le: "
                + BookingDAO.getInstance().create(booking1) + "</h2>"
                + "</br>"
                + "<h3> Nous sommes heureux, Mr/Mme " + booking1.getBookingName()
                +" de vous acceuillir dans notre hotel" + " du   " + booking1.getArrivalDate()
                + "   au   " + booking1.getDepartureDate() + ".</h3>";
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Booking readBooking(@QueryParam("idBooking") int idBooking){
        return BookingDAO.getInstance().read(idBooking);
    }

    @GET
    @Path("/readToUpdate")
    @Produces("application/json")
    public Booking readBookingToUpdate(@QueryParam("idBookingU") int idBookingU){
        return BookingDAO.getInstance().read(idBookingU);
    }

    @GET
    @Path("/update")
    @Produces("text/html")
    public String updateBooking(){
        Booking booking2 =new Booking();
            booking2.setBookingName("Andy");
            booking2.setBookingRoom(1515);
            booking2.setArrivalDate(new Date());
            booking2.setDepartureDate(new Date());
        BookingDAO.getInstance().update(booking2);
        return "<h3> Update Completed</h3>";
    }

    @GET
    @Path("/delete")
    @Produces("text/html")
    public String deleteBooking(@QueryParam("idBookingD") int idBookingD){
        BookingDAO.getInstance().delete(idBookingD);
        return "<h3> Delete Completed</h3>";
    }

    @GET
    @Path("/readALL")
    @Produces("application/json")
    public List<Booking> readAllBooking(){
        return BookingDAO.getInstance().readALL();
    }

}
