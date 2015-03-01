package com.services;

import com.dataAccess.bean.Customer;
import com.dataAccess.dao.CustomerDAO;
import com.dataAccess.dao.RoomDAO;


import javax.ws.rs.*;

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
    @Path("/create")
    @Produces("text/html")
    public String createCustomer(@QueryParam("firstname") String f, @QueryParam("lastname") String l){
        Customer customer1 = new Customer();
            customer1.setFirstName(f);
            customer1.setLastName(l);
        return "<h2>Votre identifiant client est le: "
                + CustomerDAO.getInstance().create(customer1) + "</h2>"
                + "</br>"
                + "<h3> Nous sommes heureux de vous acceuillir dans notre hotel.</h3></br>"
                + "<h3> La réservation de votre chambre est au nom de : "
                + customer1.getFirstName() + " " + customer1.getLastName() + ".</br></h3>";
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Customer readCustomer(){
        return CustomerDAO.getInstance().read(1);
    }

    @GET
    @Path("/update")
    @Produces("text/html")
    public String updateCustomer(){
        customer.setFirstName("Joe");
        customer.setLastName("Higashi");
        CustomerDAO.getInstance().update(customer);
        return "<h3> Update customer completed</h3>";
    }

    @GET
    @Path("/delete")
    @Produces("text/html")
    public String deleteCustomer(){
        CustomerDAO.getInstance().delete(customer);
        return "<h3> Delete customer completed</h3>";
    }
}
