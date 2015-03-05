package com.services;

import com.dataAccess.bean.Room;
import com.dataAccess.dao.RoomDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by oliver on 27/02/15.
 */
@Path("/room")
public class RoomServices {

    @GET
    @Path("/create")
    @Produces("text/html")
    public String createRoom(@QueryParam("roomNumber") int roomNumber,
                             @QueryParam("roomType") String roomType,
                             @QueryParam("roomDimension") int roomDimension){
        Room room1 = new Room();
            room1.setRoomNumber(roomNumber);
            room1.setRoomType(roomType);
            room1.setRoomDimension(roomDimension);
        return "<h2>Votre identifiant de chambre est le: "
                + RoomDAO.getInstance().create(room1) + "</h2>"
                + "</br>"
                + "<h3> Nous sommes heureux de vous acceuillir dans notre hotel.</h3></br>"
                + "<h3> Votre numéro de chambre est le : " + room1.getRoomNumber() + "</br>"
                + "<h3> La dimesion de votre chambre est de : " + room1.getRoomDimension() + "</br>"
                + "<h3> Votre chambre est de type : " + room1.getRoomType() + "</br></h3>";
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Room readRoom(@QueryParam("idRoom") int idRoom){
        return RoomDAO.getInstance().read(idRoom);
    }

    @GET
    @Path("/readToUpdate")
    @Produces("application/json")
    public Room readRoomToUpdate(@QueryParam("idRoomU") int idRoom){
        return RoomDAO.getInstance().read(idRoom);
    }

    @GET
    @Path("/update")
    @Produces("text/html")
    public String updateRoom(@QueryParam("idRoomU") int idRoom,
                             @QueryParam("roomNumberU") int roomNumber,
                             @QueryParam("roomTypeU") String roomType,
                             @QueryParam("roomDimensionU") int roomDimension){
        Room room = RoomDAO.getInstance().read(idRoom);
            room.setRoomNumber(roomNumber);
            room.setRoomDimension(roomDimension);
            room.setRoomType(roomType);
        RoomDAO.getInstance().update(room);
        return "<h3> Update Completed</h3>";
    }

    @GET
    @Path("/delete")
    @Produces("text/html")
    public String deleteRoom(@QueryParam("idRoomD") int idRoomD){
        RoomDAO.getInstance().delete(idRoomD);
        return "<h3> Delete Completed</h3>";
    }

}
