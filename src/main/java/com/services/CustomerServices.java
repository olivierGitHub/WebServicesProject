package com.services;

import com.dataAccess.bean.Customer;
import com.dataAccess.dao.CustomerDAO;
import com.dataAccess.dao.RoomDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by oliver on 27/02/15.
 */
@Path("/customer")
public class CustomerServices {

    Customer customer = new Customer();
        {
            customer.setFirstName("Terry");
            customer.setLastName("Bogard");
        }

    @GET
    @Produces("text/html")
    public String createCustomer(){
        return "<h2>Votre identifiant client est le: "
                + CustomerDAO.getInstance().create(customer) + "</h2>"
                + "</br>"
                + "<h3> Nous sommes heureux de vous acceuillir dans notre hotel.</h3></br>"
                + "<h3> La réservation de votre chambre est au nom de : "
                + customer.getFirstName() + " " + customer.getLastName() + ".</br></h3>";
    }
}
