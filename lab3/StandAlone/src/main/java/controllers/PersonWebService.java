package controllers;


import exceptions.NoSuchUserException;
import exceptions.WrongEmailFormat;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

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
                                                 String name) throws NoSuchUserException {
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
                                               String email) throws WrongEmailFormat {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByEmail(email);
    }

    @WebMethod(operationName = "getPersonsByPhone")
    public List<User> getPersonsByPhone(@WebParam(name = "personPhone")
                                               String phone) {
        UserDAO dao = new UserDAO(getConnection());
        return dao.getPersonsByPhone(phone);
    }

    @WebMethod(operationName = "createPearson")
    public int createUser(@WebParam(name = "name") @XmlElement(required = true) String name,
                          @WebParam(name = "surname") @XmlElement(required = true) String surname,
                          @WebParam(name = "phoneNumber") @XmlElement(required = true) int number,
                          @WebParam(name = "email") @XmlElement(required = true) String email,
                          @WebParam(name = "password") @XmlElement(required = true) String password){
        UserDAO dao = new UserDAO(getConnection());
        return dao.createUser(name,surname,number,email,password);
    }

    @WebMethod(operationName = "deletePearson")
    public String deleteUser(@WebParam(name = "id") @XmlElement(required = true) int id){

        return  new UserDAO(getConnection()).deleteUser(id);
    }

    @WebMethod(operationName = "updatePearson")
    public String updateUser(@WebParam(name = "name")  String name,
                            @WebParam(name = "surname")  String surname,
                            @WebParam(name = "phoneNumber")  int number,
                            @WebParam(name = "email")  String email,
                            @WebParam(name = "password")  String password,
                            @WebParam(name = "id") @XmlElement(required = true) int id  ){
        UserDAO dao = new UserDAO(getConnection());
        return dao.updateUser(name,surname,number,email,password,id);
    }










}
