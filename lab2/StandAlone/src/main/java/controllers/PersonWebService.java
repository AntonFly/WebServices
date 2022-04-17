package controllers;


import javax.activation.DataHandler;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.awt.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.xml.ws.soap.MTOM;

import static controllers.ConnectionUtil.getConnection;
@MTOM
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

    private Path path = Paths.get("C:\\Users\\antonAdmin\\OneDrive\\Рабочий стол\\test.jpeg");

    @WebMethod(operationName = "uploadFile")
    public void uploadFile(DataHandler file) {

        try (InputStream input = file.getInputStream();
             OutputStream output = new FileOutputStream(
                     new File(path.toString()));) {

            byte[] b = new byte[100000];
            int bytesRead = 0;
            while ((bytesRead = input.read(b)) != -1) {
                output.write(b, 0, bytesRead);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    private Path path1 = Paths.get("C:\\Users\\antonAdmin\\OneDrive\\Рабочий стол\\_1fg38J0_qQ.jpg");

    @WebMethod(operationName = "downloadFile")
    public Image downloadImage() throws IOException {

        File image = new File(path1.toString());
        return  ImageIO.read(image);

    }








}
