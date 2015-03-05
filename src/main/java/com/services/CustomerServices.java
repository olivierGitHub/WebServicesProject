package com.services;

import com.dataAccess.bean.Customer;
import com.dataAccess.dao.CustomerDAO;
import javax.ws.rs.*;

/**
 * Created by oliver on 27/02/15.
 */
@Path("/customer")
public class CustomerServices {

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
    public Customer readCustomer(@QueryParam("idCustomer") int id){
        return CustomerDAO.getInstance().read(id);
    }

    @GET
    @Path("/readToUpdate")
    @Produces("application/json")
    public Customer readCustomerToUpdate(@QueryParam("idCustomerU") int id){
        return CustomerDAO.getInstance().read(id);
    }

    @GET
    @Path("/update")
    @Produces("text/html")
    public String updateCustomer(@QueryParam("idCustomerU") int idCustomerU,
                                 @QueryParam("firstnameU") String firstnameU,
                                 @QueryParam("lastnameU") String lastnameU){
        Customer customer2 = CustomerDAO.getInstance().read(idCustomerU);
            customer2.setFirstName(firstnameU);
            customer2.setLastName(lastnameU);
        CustomerDAO.getInstance().update(customer2);
        return "<h3> Update customer completed</h3>";
    }

    @GET
    @Path("/delete")
    @Produces("text/html")
    public String deleteCustomer(@QueryParam("idCustomerD") int id){
        CustomerDAO.getInstance().delete(id);
        return "<h3> Delete customer completed</h3>";
    }
}
