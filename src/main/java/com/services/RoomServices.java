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
    public void createRoom(@QueryParam("roomNumber") int roomNumber,
                             @QueryParam("roomType") String roomType,
                             @QueryParam("roomDimension") int roomDimension){
        Room room1 = new Room();
            room1.setRoomNumber(roomNumber);
            room1.setRoomType(roomType);
            room1.setRoomDimension(roomDimension);
        RoomDAO.getInstance().create(room1);
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Room readRoom(@QueryParam("idRoom") int idRoom){
        return RoomDAO.getInstance().read(idRoom);
    }

    /* Ce web service est utilisé UNIQUEMENT pour l’auto-complete de la VUE */
    @GET
    @Path("/readToUpdate")
    @Produces("application/json")
    public Room readRoomToUpdate(@QueryParam("idRoomU") int idRoom){
        return RoomDAO.getInstance().read(idRoom);
    }

    @GET
    @Path("/update")
    public void updateRoom(@QueryParam("idRoomU") int idRoom,
                             @QueryParam("roomNumberU") int roomNumber,
                             @QueryParam("roomTypeU") String roomType,
                             @QueryParam("roomDimensionU") int roomDimension){
        Room room = RoomDAO.getInstance().read(idRoom);
            room.setRoomNumber(roomNumber);
            room.setRoomDimension(roomDimension);
            room.setRoomType(roomType);
        RoomDAO.getInstance().update(room);
    }

    @GET
    @Path("/delete")
    public void deleteRoom(@QueryParam("idRoomD") int idRoomD){
        RoomDAO.getInstance().delete(idRoomD);
    }

}
