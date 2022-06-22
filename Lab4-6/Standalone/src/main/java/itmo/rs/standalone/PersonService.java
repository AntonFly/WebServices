package itmo.rs.standalone;

import itmo.rs.standalone.exceptions.AuthException;
import itmo.rs.standalone.exceptions.NoSuchUserException;
import itmo.rs.standalone.exceptions.WrongEmailFormatException;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

import static itmo.rs.standalone.ConnectionUtil.getConnection;

@RequestScoped
@Path("/Persons")
@Produces({MediaType.APPLICATION_JSON})
public class PersonService {

    @Resource(lookup = "jdbc/HomeBase")
    private DataSource dataSource;

    @GET
    @Path("/hello-world")
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
                                       String name) throws NoSuchUserException {
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
                                        String email) throws WrongEmailFormatException {
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
    @PUT
    @Path("/createPearson")
    public int createUser(@QueryParam("name") @XmlElement(required = true) String name,
                          @QueryParam("surname") @XmlElement(required = true) String surname,
                          @QueryParam("phoneNumber") @XmlElement(required = true) int number,
                          @QueryParam("email") @XmlElement(required = true) String email,
                          @HeaderParam("Authorization") String authString
                          ) throws UnsupportedEncodingException, AuthException {
        isUserAuthenticated(authString);
        UserDAO dao = new UserDAO(getConnection());
        return dao.createUser(name,surname,number,email);
    }
    @DELETE
    @Path("/deletePearson")
    public String deleteUser(@QueryParam("id") @XmlElement(required = true) int id,
                             @HeaderParam("Authorization") String authString) throws UnsupportedEncodingException, AuthException {
        isUserAuthenticated(authString);
        return  new UserDAO(getConnection()).deleteUser(id);
    }

    @POST
    @Path("/updatePearson")
    public String updateUser(@QueryParam("name")  String name,
                             @QueryParam("surname")  String surname,
                             @QueryParam("phoneNumber")  int number,
                             @QueryParam("email")  String email,
                             @QueryParam("id") @XmlElement(required = true) int id,
                             @HeaderParam("Authorization") String authString) throws UnsupportedEncodingException, AuthException {
        UserDAO dao = new UserDAO(getConnection());
        isUserAuthenticated(authString);
        return dao.updateUser(name,surname,number,email,id);
    }

    private void isUserAuthenticated(String authString) throws UnsupportedEncodingException, AuthException {

        String[] tokens = (new String(Base64.getDecoder().decode(authString.split(" ")[1]), "UTF-8")).split(":");
        final String username = tokens[0];
        final String password = tokens[1];

        if (!username.equals("AVRA") || !password.equals("AVRA")) {
            throw AuthException.DEFAULT_INSTANCE;
        }

    }

}