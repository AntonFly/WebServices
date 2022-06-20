package controllers;


import exceptions.NoSuchUserException;
import exceptions.WrongEmailFormat;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

import static controllers.ConnectionUtil.getConnection;

@WebService(serviceName = "PersonService")
public class PersonWebService {

    @Resource
    WebServiceContext wsctx;

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
    public String createUser(@WebParam(name = "name") @XmlElement(required = true) String name,
                          @WebParam(name = "surname") @XmlElement(required = true) String surname,
                          @WebParam(name = "phoneNumber") @XmlElement(required = true) int number,
                          @WebParam(name = "email") @XmlElement(required = true) String email,
                          @WebParam(name = "password") @XmlElement(required = true) String password){
        UserDAO dao = new UserDAO(getConnection());
        if (getAuthString())
            return String.valueOf(dao.createUser(name,surname,number,email,password));
        else
            return "Unknown User!";
    }

    @WebMethod(operationName = "deletePearson")
    public String deleteUser(@WebParam(name = "id") @XmlElement(required = true) int id){
        if (getAuthString())
            return  new UserDAO(getConnection()).deleteUser(id);
        else
            return "Unknown User!";
    }

    @WebMethod(operationName = "updatePearson")
    public String updateUser(@WebParam(name = "name")  String name,
                            @WebParam(name = "surname")  String surname,
                            @WebParam(name = "phoneNumber")  int number,
                            @WebParam(name = "email")  String email,
                            @WebParam(name = "password")  String password,
                            @WebParam(name = "id") @XmlElement(required = true) int id  ){
        UserDAO dao = new UserDAO(getConnection());
        if (getAuthString())
            return dao.updateUser(name,surname,number,email,password,id);
        else
            return "Unknown User!";
    }


    public Boolean getAuthString() {

        MessageContext mctx = wsctx.getMessageContext();

        //get detail from request headers
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");

        String username = "";
        String password = "";

        if(userList!=null){
            //get username
            username = userList.get(0).toString();
        }

        if(passList!=null){
            //get password
            password = passList.get(0).toString();
        }

        //Should validate username and password with database
        if (username.equals("AVRA") && password.equals("AVRA")){
            return true;
        }else{
            return false;
        }

    }









}
