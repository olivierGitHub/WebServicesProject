package com.rest;

/**
 * Created by oliver on 27/02/15.
 */
import com.services.BookingServices;
import com.services.CustomerServices;
import com.services.RoomServices;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;


public class MyServices extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public MyServices() {
        singletons.add(new RoomServices());
        singletons.add(new CustomerServices());
        singletons.add(new BookingServices());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
