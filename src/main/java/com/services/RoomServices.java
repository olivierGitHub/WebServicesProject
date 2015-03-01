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
    @Path("/create")
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

    @GET
    @Path("/read")
    @Produces("application/json")
    public Room readRoom(){
        return RoomDAO.getInstance().read(1);
    }

    @GET
    @Path("/update")
    @Produces("text/html")
    public String updateRoom(){
        room.setRoomNumber(1111);
        room.setRoomDimension(11);
        room.setRoomType("Double");
        RoomDAO.getInstance().update(room);
        return "<h3> Update Completed</h3>";
    }

    @GET
    @Path("/delete")
    @Produces("text/html")
    public String deleteRoom(int id){
        RoomDAO.getInstance().delete(id);
        return "<h3> Delete Completed</h3>";
    }

}
