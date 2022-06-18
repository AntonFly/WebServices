package com.example.j2ee;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@Path("/Person")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {

    @Resource(lookup = "jdbc/HomeBase")
    private DataSource dataSource;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("/getAllPersons")
    public List<User> getPersons() {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersons();
    }

    @GET
    @Path("/getPersonsByName")
    public List<User> getPersonsByName(@QueryParam("personName")
                                       String name) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByName(name);
    }

    @GET
    @Path("/getPersonsByNameAndSurname")
    public List<User> getPersonsByNameAndSurname(@QueryParam("personName") String name,
                                                 @QueryParam("personSurname") String surname) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByNameAndSurname(name, surname);
    }

    @GET
    @Path("/getPersonsByEmail")
    public List<User> getPersonsByEmail(@QueryParam("personEmail")
                                        String email) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByEmail(email);
    }
    @GET
    @Path("/getPersonsByPhone")
    public List<User> getPersonsByPhone(@QueryParam("personPhone")
                                        String phone) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByPhone(phone);
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {

            Logger.getLogger(PersonResource.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        return result;
    }
}

