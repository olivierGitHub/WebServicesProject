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
    public void createBooking(@QueryParam("bookingName") String bookingName,
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
        BookingDAO.getInstance().create(booking1);
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Booking readBooking(@QueryParam("idBooking") int idBooking){
        return BookingDAO.getInstance().read(idBooking);
    }

    /* Ce web service est utilisé UNIQUEMENT pour l’auto-complete de la VUE */
    @GET
    @Path("/readToUpdate")
    @Produces("application/json")
    public Booking readBookingToUpdate(@QueryParam("idBookingU") int idBookingU){
        return BookingDAO.getInstance().read(idBookingU);
    }

    @GET
    @Path("/update")
    public void updateBooking(@QueryParam("idBookingU") int idBooking,
                                @QueryParam("bookingNameU") String bookingName,
                                @QueryParam("bookingRoomU") int bookingRoom,
                                @QueryParam("arrivalDateU") String arrivalDate,
                                @QueryParam("departureDateU") String departureDate){
        Booking booking2 =BookingDAO.getInstance().read(idBooking);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            booking2.setBookingName(bookingName);
            booking2.setBookingRoom(bookingRoom);
            booking2.setArrivalDate(sdf.parse(arrivalDate));
            booking2.setDepartureDate(sdf.parse(departureDate));
        }catch(ParseException e){
            e.printStackTrace();}
        BookingDAO.getInstance().update(booking2);
    }

    @GET
    @Path("/delete")
    public void deleteBooking(@QueryParam("idBookingD") int idBookingD){
        BookingDAO.getInstance().delete(idBookingD);
    }

    @GET
    @Path("/readALL")
    @Produces("application/json")
    public List<Booking> readAllBooking(){
        return BookingDAO.getInstance().readALL();
    }

}
