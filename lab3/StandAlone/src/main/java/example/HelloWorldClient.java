package example;

import com.sun.corba.se.spi.activation.Activator;

import exceptions.WrongEmailFormat;
import mypackage.*;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HelloWorldClient {
          private static final String WS_URL = "http://localhost:8088/PersonService?wsdl";
  public static void main(String[] argv) {
      try {
          URL url=new URL("http://localhost:8088/PersonService?wsdl");
          PersonService personService=new PersonService(url);
          PersonWebService personWebService = personService.getPersonWebServicePort();
          Map<String, Object> req_ctx = ((BindingProvider)personWebService).getRequestContext();
          req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

          Map<String, List<String>> headers = new HashMap<String, List<String>>();
          headers.put("Username", Collections.singletonList("AVRA"));
          headers.put("Password", Collections.singletonList("AVRA"));
          req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
          System.out.println("Запрос всех пользователей:getAllPersons():");
          List<User> persons=personWebService.getAllPersons();
          for(User user:persons){
              System.out.println(user.toString());
          }
          
          try{
              System.out.println("Total persons:"+persons.size());
              System.out.println("Запрос всех пользователей alexk2109@gmail.com:getPersonByEmail():");
              persons=personWebService.getPersonsByEmail("alexk2109@gmail.com");

              for(User user:persons){
                  System.out.println(user.toString());
              }
                System.out.println("Total persons:"+persons.size());
                System.out.println("Запрос всех пользователей alexk2109gmail.com:getPersonByEmail() Невалидный емайл:");
                persons=personWebService.getPersonsByEmail("alexk2109gmail.com");

                for(User user:persons){
                    System.out.println(user.toString());
                }
                System.out.println("Total persons:"+persons.size());
          }catch (mypackage.WrongEmailFormat e){
              System.out.println("Error message: " + e.getFaultInfo().getMessage());
          }
          try{
          System.out.println("getPersonByName(\"Иван\")");
          persons=personWebService.getPersonsByName("Иван");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.size());

              System.out.println("getPersonByName(\"Иван889\") Невалидное имя");
              persons=personWebService.getPersonsByName("Иван889");

              for(User user:persons){
                  System.out.println(user.toString());
              }
              System.out.println("Total persons:"+persons.size());
          }catch (NoSuchUserException e){
              System.out.println("Error message: " + e.getFaultInfo().getMessage());

          }
          System.out.println("getPersonsByNameAndSurname(\"Тест\",\"Тестов\")");
          persons=personWebService.getPersonsByNameAndSurname("Тест","Тестов");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.size());
          System.out.println("etPersonsByPhone(\"436456436\")");
          persons=personWebService.getPersonsByPhone("436456436");

          for(User user:persons){
              System.out.println(user.toString());
          }
          System.out.println("Total persons:"+persons.size());
          System.out.println("createPearson(\"Anton\",\"Avr\",99988867,\"email@email.com\",\"password\")");
          int id = personWebService.createPearson("Anton","Avr",99988867,"email@email.com","password");
          System.out.println("Id of created person is "+id);
          System.out.println("updatePearson(\"Jac\",null,0,null,null,id)");
          System.out.println(personWebService.updatePearson("Jac",null,0,null,null,id));
          System.out.println("deletePearson(id)");
          System.out.println(personWebService.deletePearson(id));


      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
  }
}
