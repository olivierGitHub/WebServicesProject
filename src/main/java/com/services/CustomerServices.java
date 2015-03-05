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
    public void createCustomer(@QueryParam("firstname") String f, @QueryParam("lastname") String l){
        Customer customer1 = new Customer();
            customer1.setFirstName(f);
            customer1.setLastName(l);
        CustomerDAO.getInstance().create(customer1);
    }

    @GET
    @Path("/read")
    @Produces("application/json")
    public Customer readCustomer(@QueryParam("idCustomer") int id){
        return CustomerDAO.getInstance().read(id);
    }

    /* Ce web service est utilisé UNIQUEMENT pour l’auto-complete de la VUE */
    @GET
    @Path("/readToUpdate")
    @Produces("application/json")
    public Customer readCustomerToUpdate(@QueryParam("idCustomerU") int id){
        return CustomerDAO.getInstance().read(id);
    }

    @GET
    @Path("/update")
    public void updateCustomer(@QueryParam("idCustomerU") int idCustomerU,
                                 @QueryParam("firstnameU") String firstnameU,
                                 @QueryParam("lastnameU") String lastnameU){
        Customer customer2 = CustomerDAO.getInstance().read(idCustomerU);
            customer2.setFirstName(firstnameU);
            customer2.setLastName(lastnameU);
        CustomerDAO.getInstance().update(customer2);
    }

    @GET
    @Path("/delete")
    public void deleteCustomer(@QueryParam("idCustomerD") int id){
        CustomerDAO.getInstance().delete(id);
    }
}
