package org.example.requests;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import org.example.User;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class Requests {

    public static List<User> getAllPersons(Client client, String URL)
    {
        WebResource webResource = client.resource(URL+"getAllPersons");

        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: "+ response.getStatus() + "\n\r"+ response.getEntity(String.class) );
        }
        GenericType<List<User>> type = new GenericType<List<User>>()
        {};
        return response.getEntity(type);
    }

    public static List<User> getPersonByName(Client client, String URL, String name)
    {
        WebResource webResource = client.resource(URL+"getPersonsByName");
        if (name != null) {
            webResource = webResource.queryParam("personName", name);
        }

        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: "+ response.getStatus() + "\n\r"+ response.getEntity(String.class) );
        }
        GenericType<List<User>> type = new GenericType<List<User>>()
        {};
        return response.getEntity(type);
    }

    public static List<User> getPersonEmail(Client client, String URL, String email)
    {
        WebResource webResource = client.resource(URL+"getPersonsByEmail");
        if (email != null) {
            webResource = webResource.queryParam("personEmail", email);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            System.err.println("Request failed: "+ response.getStatus() + "\n\r"+ response.getEntity(String.class) );
        }
        GenericType<List<User>> type = new GenericType<List<User>>()
        {};
        return response.getEntity(type);
    }

    public static String createPerson(Client client, String URL, String name, String email , String surname, String phone)
    {
        WebResource webResource = client.resource(URL+"createPearson");
        if (name != null) {
            webResource = webResource.queryParam("name", name);
        }
        if (surname != null) {
            webResource = webResource.queryParam("surname", surname);
        }
        if (phone != null) {
            webResource = webResource.queryParam("phoneNumber", phone);
        }
        if (email != null) {
            webResource = webResource.queryParam("email", email);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).put(ClientResponse.class);

        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: "+ response.getStatus() + "\n\r"+ response.getEntity(String.class) );
        }
//        GenericType<List<User>> type = new GenericType<List<User>>()
//        {};
        return response.getEntity(String.class);
    }

    public static String deletePerson(Client client, String URL, String id)
    {
        WebResource webResource = client.resource(URL+"deletePearson");
        if (id != null) {
            webResource = webResource.queryParam("id", id);
        }
        ClientResponse response =
                webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        if (response.getStatus() !=
                ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed: "+ response.getStatus() + "\n\r"+ response.getEntity(String.class) );
        }

        return response.getEntity(String.class);
    }





}

