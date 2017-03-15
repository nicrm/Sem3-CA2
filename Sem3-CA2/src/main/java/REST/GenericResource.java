/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import entities.Person;
import facade.PersonFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Peter Henriksen
 */
@Path("person")
public class GenericResource {

    static Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    EntityManager em;

    PersonFacade pf = new PersonFacade(emf);

    @GET
    @Path("persons/{userid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person getPersonById(@PathParam("userid") int userid) {
        return pf.getPerson(userid);
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public void deleteXml(String content) {

    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void postXml(String content) {

    }
}
