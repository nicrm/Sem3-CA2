/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Interface.IFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Person;
import facade.PersonFacade;
import java.util.List;
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
public class PersonResource {

    private static final IFacade FACADE = new PersonFacade(Persistence.createEntityManagerFactory("PU"));
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public PersonResource() {
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
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     */
    
    
    @PUT
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(String jsonPerson) {
        Person person = GSON.fromJson(jsonPerson, Person.class);
        Person p = (Person) FACADE.addInfoEntity(person);
        
        return GSON.toJson(p);
    }
    
    @POST
    @Path("edit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String editPerson(String jsonPerson) {
        Person person = GSON.fromJson(jsonPerson, Person.class);
        Person p = (Person) FACADE.editInfoEntity(person);
        
        return GSON.toJson(p);
    }
    
    @DELETE
    @Path("delete/{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePerson(@PathParam("id") int id)  {
        Person person = (Person) FACADE.deleteInfoEntity(id);
        
        return GSON.toJson(person);
    }
    
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllPersons() {
        List<Person> people = FACADE.getAllPersons();
        
        return GSON.toJson(people);
    }
    
    
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
