package com.services;

import com.dataAccess.bean.Room;
import com.dataAccess.dao.BookingDAO;
import com.dataAccess.dao.RoomDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by oliver on 27/02/15.
 */
@Path("/room")
public class RoomServices {

    Room room = new Room();
    {
        room.setRoomNumber(4842);
        room.setRoomDimension(25);
        room.setRoomType("Single");
    }

    @GET
    @Produces("text/html")
    public String createRoom(){
        return "<h2>Votre identifiant de chambre est le: "
                + RoomDAO.getInstance().create(room) + "</h2>"
                + "</br>"
                + "<h3> Nous sommes heureux de vous acceuillir dans notre hotel.</h3></br>"
                + "<h3> Votre numéro de chambre est le : " + room.getRoomNumber() + "</br>"
                + "<h3> La dimesion de votre chambre est de : " + room.getRoomDimension() + "</br>"
                + "<h3> Votre chambre est de type : " + room.getRoomType() + "</br></h3>";

    }
}
