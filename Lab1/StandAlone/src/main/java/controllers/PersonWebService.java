package controllers;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static controllers.ConnectionUtil.getConnection;

@WebService(serviceName = "PersonService")
public class PersonWebService {


    @WebMethod(operationName = "getAllPersons")
    public List<User> getPersons() {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersons();
    }
    @WebMethod(operationName = "getPersonsByName")
    public List<User> getPersonsByName(@WebParam(name = "personName")
                                                 String name) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByName(name);
    }

    @WebMethod(operationName = "getPersonsByNameAndSurname")
    public List<User> getPersonsByNameAndSurname(@WebParam(name = "personName") String name,
                                                 @WebParam(name = "personSurname") String surname) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByNameAndSurname(name, surname);
    }

    @WebMethod(operationName = "getPersonsByEmail")
    public List<User> getPersonsByEmail(@WebParam(name = "personEmail")
                                               String email) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByEmail(email);
    }

    @WebMethod(operationName = "getPersonsByPhone")
    public List<User> getPersonsByPhone(@WebParam(name = "personPhone")
                                               String phone) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByPhone(phone);
    }






}
