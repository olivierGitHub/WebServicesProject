package com.dataAccess.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by oliver on 27/02/15.
 */
@Entity
public class Room {

    @Id
    @GeneratedValue
    private int idRoom;
    private int roomNumber;
    private String roomType;
    private int roomDimension;

    public int getIdRoom() {
        return idRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomDimension() {
        return roomDimension;
    }
    public void setRoomDimension(int roomDimension) {
        this.roomDimension = roomDimension;
    }

}
