package rest.service;

import com.google.gson.Gson;
import facades.CustomerFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("bankcustomer")
public class BankCustomerResource {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
    private static CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
    private static Gson gson = new Gson();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"succes\"}";
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCustomerById(@PathParam("id") int id){
        return gson.toJson(facade.getCustomerById(id));
    }
    
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCustomers(){
        return gson.toJson(facade.getAllBankCustomers());
    }
    
    
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void create(BankCustomer entity) {
//        throw new UnsupportedOperationException();
//    }
//    
//    @PUT
//    @Path("/{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void update(BankCustomer entity, @PathParam("id") int id) {
//        throw new UnsupportedOperationException();
//    }
}
