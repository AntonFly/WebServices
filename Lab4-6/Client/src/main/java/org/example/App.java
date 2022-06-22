package org.example;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import org.example.requests.Requests;

import java.util.List;
import javax.naming.AuthenticationException;
import javax.ws.rs.core.MediaType;

public class App 
{
    private static final String URL = "http://localhost:8088/rest/Persons/";
    public static void main( String[] args ) throws AuthenticationException {
        Client client = Client.create();
        System.out.println("Get all person");
        printList(Requests.getAllPersons(client,URL));
        System.out.println("========================");
        try{
        System.out.println("Get person by name");
        printList(Requests.getPersonByName(client,URL,"Anton"));
        System.out.println("========================");
        System.out.println("Get person by wrong name");
        printList(Requests.getPersonByName(client,URL,"Anton989"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("========================");
        try{
        System.out.println("Get person by Email");
        printList(Requests.getPersonEmail(client,URL,"alexk2109@gmail.com"));
        System.out.println("========================");
        System.out.println("Get person by wrong Email");
        printList(Requests.getPersonEmail(client,URL,"alexk2109gmail.com"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("========================");
        System.out.println("Create person");
        String id = Requests.createPerson(client,URL,"Ivan","alexk@gmail.com","Ivanov","9898");
        System.out.println(id);
        System.out.println("========================");
        System.out.println("Delete person");
        System.out.println(Requests.deletePerson(client,URL,id));
        System.out.println("========================");
    }
    private static void printList(List<User> persons) {
        for (User person : persons) {
            System.out.println(person);
        }
    }
}
